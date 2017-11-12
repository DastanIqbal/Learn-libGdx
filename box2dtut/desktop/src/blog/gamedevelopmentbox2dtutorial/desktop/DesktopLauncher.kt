package blog.gamedevelopmentbox2dtutorial.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import blog.gamedevelopmentbox2dtutorial.Box2DTutorial

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(Box2DTutorial(), config)
    }
}
