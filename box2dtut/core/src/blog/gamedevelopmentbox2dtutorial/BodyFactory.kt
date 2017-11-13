package blog.gamedevelopmentbox2dtutorial

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*


/**
 * Created by dastaniqbal on 13/11/2017.
 * dastanIqbal@marvelmedia.com
 * 13/11/2017 10:19
 */
class BodyFactory private constructor(private val world: World) {
    private val DEGTORAD = 0.0174533f

    companion object {
        val STEEL = 0
        val WOOD = 1
        val RUBBER = 2
        val STONE = 3
        @Volatile private var newInstance: BodyFactory? = null
        fun getInstance(world: World): BodyFactory = newInstance ?: synchronized(this) {
            newInstance ?: BodyFactory(world).also { newInstance = it }
        }

        fun makeFixture(material: Int, shape: Shape): FixtureDef {
            val fixtureDef = FixtureDef()
            fixtureDef.shape = shape
            when (material) {
                0 -> {
                    fixtureDef.density = 1f
                    fixtureDef.friction = .3f
                    fixtureDef.restitution = .1f
                }
                1 -> {
                    fixtureDef.density = .5f
                    fixtureDef.friction = .7f
                    fixtureDef.restitution = .3f
                }
                2 -> {
                    fixtureDef.density = 1f
                    fixtureDef.friction = 0f
                    fixtureDef.restitution = 1f
                }
                3 -> {
                    fixtureDef.density = 1f
                    fixtureDef.friction = .9f
                    fixtureDef.restitution = .01f
                }
                else -> {
                    fixtureDef.density = 7f
                    fixtureDef.friction = .5f
                    fixtureDef.restitution = .3f
                }
            }
            return fixtureDef
        }
    }

    fun makeCirclePolyBody(posx: Float, posy: Float, radius: Float, material: Int, bodyType: BodyDef.BodyType, fixedRotation: Boolean): Body {
        // create a definition
        val bodyDef = BodyDef()
        bodyDef.type = bodyType
        bodyDef.position.x = posx
        bodyDef.position.y = posy
        bodyDef.fixedRotation = fixedRotation

        //create the body to attach said definition
        val boxBody = world.createBody(bodyDef)
        val circleShape = CircleShape()
        circleShape.radius = radius / 2
        boxBody.createFixture(makeFixture(material, circleShape))
        circleShape.dispose()
        return boxBody
    }

    fun makeCirclePolyBody(posx: Float, posy: Float, radius: Float, material: Int, bodyType: BodyDef.BodyType): Body {
        return makeCirclePolyBody(posx, posy, radius, material, bodyType, false)
    }

    fun makeBoxPolyBody(posx: Float, posy: Float, width: Float, height: Float, material: Int, bodyType: BodyDef.BodyType): Body {
        return makeBoxPolyBody(posx, posy, width, height, material, bodyType, false);
    }

    fun makeBoxPolyBody(posx: Float, posy: Float, width: Float, height: Float, material: Int, bodyType: BodyDef.BodyType, fixedRotation: Boolean): Body {
        // create a definition
        val bodyDef = BodyDef()
        bodyDef.type = bodyType
        bodyDef.position.x = posx
        bodyDef.position.y = posy
        bodyDef.fixedRotation = fixedRotation

        //create the body to attach said definition
        val boxBody = world.createBody(bodyDef)
        val polygonShape = PolygonShape()
        polygonShape.setAsBox(width / 2, width / 2)
        boxBody.createFixture(makeFixture(material, polygonShape))
        polygonShape.dispose()
        return boxBody
    }

    fun makePolygonShapeBody(vararg vertices: Vector2, posx: Float, posy: Float, material: Int, bodyType: BodyDef.BodyType, fixedRotation: Boolean): Body {
        // create a definition
        val bodyDef = BodyDef()
        bodyDef.type = bodyType
        bodyDef.position.x = posx
        bodyDef.position.y = posy
        bodyDef.fixedRotation = fixedRotation

        //create the body to attach said definition
        val boxBody = world.createBody(bodyDef)
        val polygonShape = PolygonShape()
        polygonShape.set(vertices)
        boxBody.createFixture(makeFixture(material, polygonShape))
        polygonShape.dispose()
        return boxBody
    }

    fun makeConeSensor(body: Body, size: Float) {
        val fixtureDef = FixtureDef()
       // fixtureDef.isSensor = true
        val polygon = PolygonShape()
        val radius = size
        val vertices = arrayOfNulls<Vector2>(5)
        vertices[0] = Vector2(0f, 0f)
        for (i in 2..5) {
            val angle = (i / 6.0 * 145 * DEGTORAD).toFloat() // convert degrees to radians
            vertices[i - 1] = Vector2(radius * Math.cos(angle.toDouble()).toFloat(), radius * Math.sin(angle.toDouble()).toFloat())
        }
        polygon.set(vertices)
        fixtureDef.shape = polygon
        body.createFixture(fixtureDef)
        polygon.dispose()
    }

}