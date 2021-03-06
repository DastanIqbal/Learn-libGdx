package blog.gamedevelopmentbox2dtutorial.views

import blog.gamedevelopmentbox2dtutorial.Box2DTutorial
import com.badlogic.gdx.Screen

/**
 * Created by dastaniqbal on 12/11/2017.

 * 12/11/2017 1:21
 */

class LoadingScreen(private val parent: Box2DTutorial) : Screen {

    override fun show() {

    }

    override fun render(delta: Float) {
        parent.changeScreen(Box2DTutorial.MENU)
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
