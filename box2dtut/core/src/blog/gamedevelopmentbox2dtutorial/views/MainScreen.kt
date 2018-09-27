package blog.gamedevelopmentbox2dtutorial.views

import blog.gamedevelopmentbox2dtutorial.Box2DTutorial
import blog.gamedevelopmentbox2dtutorial.model.B2DModel
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer

/**
 * Created by dastaniqbal on 12/11/2017.

 * 12/11/2017 1:21
 */

class MainScreen(private val parent: Box2DTutorial) : Screen {
    val model = B2DModel()
    val cam = OrthographicCamera(32f, 24f)
    val debugRenderer = Box2DDebugRenderer(true, true, true, true, true, true)

    override fun show() {

    }

    override fun render(delta: Float) {
        model.logicStep(delta)
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        debugRenderer.render(model.world,cam.combined)
    }

    override fun resize(width: Int, height: Int) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }

    override fun dispose() {

    }
}
