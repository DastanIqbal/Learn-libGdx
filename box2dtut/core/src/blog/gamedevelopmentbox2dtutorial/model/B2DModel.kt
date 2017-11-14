package blog.gamedevelopmentbox2dtutorial.model

import blog.gamedevelopmentbox2dtutorial.B2DContactListener
import blog.gamedevelopmentbox2dtutorial.BodyFactory
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*

/**
 * Created by dastaniqbal on 12/11/2017.
 * dastanIqbal@marvelmedia.com
 * 12/11/2017 6:47
 */
class B2DModel {
    val world = World(Vector2(0f, -10f), true)
    var isSwimming = false
    var player: Body

    init {
        world.setContactListener(B2DContactListener(this))
        createFloor()
        // get our body factory singleton and store it in bodyFactory
        val bodyFactory = BodyFactory.getInstance(world)

        // add a player
        player = bodyFactory.makeBoxPolyBody(1f, 1f, 2f, 2f, BodyFactory.RUBBER, BodyDef.BodyType.DynamicBody)

        // add some water
        val water = bodyFactory.makeBoxPolyBody(1f, -8f, 40f, 10f, BodyFactory.RUBBER, BodyDef.BodyType.StaticBody)
        water.userData = "IAMTHESEA"
        // make the water a sensor so it doesn't obstruct our player
        bodyFactory.makeAllFixturesSensors(water)
    }

    fun logicStep(delta: Float) {
        if (isSwimming) {
            player.applyForceToCenter(0f, 50f, true)
        }
        world.step(delta, 3, 3)
    }

    private var bodyd: Body? = null

    private fun createObject() {
        //create a new body definition (type and location)
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.DynamicBody
        bodyDef.position.set(0f, 0f)

        // add it to the world
        bodyd = world.createBody(bodyDef)

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        val shape = PolygonShape()
        shape.setAsBox(1f, 1f)

        // set the properties of the object ( shape, weight, restitution(bouncyness)
        val fixtureDef = FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 1f

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyd?.createFixture(shape, 0.0f)

        // we no longer use the shape object here so dispose of it.
        shape.dispose()
    }

    private var bodys: Body? = null

    private fun createFloor() {
        //create a new body definition (type and location)
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.StaticBody
        bodyDef.position.set(0f, -10f)

        // add it to the world
        bodys = world.createBody(bodyDef)

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        val shape = PolygonShape()
        shape.setAsBox(50f, 1f)

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodys?.createFixture(shape, 0.0f)

        // we no longer use the shape object here so dispose of it.
        shape.dispose()
    }

    private var bodyk: Body? = null
    private fun createMovingObject() {
        //create a new body definition (type and location)
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.KinematicBody
        bodyDef.position.set(0f, -12f)

        // add it to the world
        bodyk = world.createBody(bodyDef)

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        val shape = PolygonShape()
        shape.setAsBox(1f, 1f)

        // set the properties of the object ( shape, weight, restitution(bouncyness)
        val fixtureDef = FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 1f

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyk?.createFixture(shape, 0.0f)

        // we no longer use the shape object here so dispose of it.
        shape.dispose()
        bodyk?.setLinearVelocity(0f, 0.75f)
    }
}