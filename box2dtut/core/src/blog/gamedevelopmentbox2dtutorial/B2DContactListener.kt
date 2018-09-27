package blog.gamedevelopmentbox2dtutorial

import blog.gamedevelopmentbox2dtutorial.model.B2DModel
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*

/**
 * Created by dastaniqbal on 14/11/2017.
 * 14/11/2017 10:01
 */
class B2DContactListener(val parent: B2DModel) : ContactListener {
    override fun endContact(contact: Contact?) {
        val fa = contact?.fixtureA
        val fb = contact?.fixtureB

        if (fa?.body?.userData == "IAMTHESEA"){
            parent.isSwimming=false
            return
        } else if (fb?.body?.userData == "IAMTHESEA"){
            parent.isSwimming=false
            return
        }
    }

    override fun beginContact(contact: Contact?) {
        System.out.println("Contact")
        val fa = contact?.fixtureA
        val fb = contact?.fixtureB
        System.out.println(fa?.body?.type.toString() + " has hit " + fb?.body?.type.toString())

        if (fa?.body?.userData == "IAMTHESEA"){
            parent.isSwimming=true
            return
        } else if (fb?.body?.userData == "IAMTHESEA"){
            parent.isSwimming=true
            return
        }

        if (fa?.body?.type == BodyDef.BodyType.StaticBody) {
            shootUpInAir(fa, fb)
        } else if (fb?.body?.type == BodyDef.BodyType.StaticBody) {
            shootUpInAir(fb, fa)
        }
    }

    private fun shootUpInAir(fa: Fixture, fb: Fixture?) {
        System.out.println("Adding Force")
        fb?.body?.applyForceToCenter(Vector2(-1000f, -1000f), true)
    }

    override fun preSolve(contact: Contact?, oldManifold: Manifold?) {

    }

    override fun postSolve(contact: Contact?, impulse: ContactImpulse?) {

    }
}