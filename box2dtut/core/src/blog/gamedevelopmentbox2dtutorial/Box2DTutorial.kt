package blog.gamedevelopmentbox2dtutorial

import blog.gamedevelopmentbox2dtutorial.views.*
import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Box2DTutorial : Game() {
    private var menuScreen: MenuScreen? = null
    private var preferencesScreen: PreferencesScreen? = null
    private var mainScreen: MainScreen? = null
    private var endScreen: EndScreen? = null
    private var loadingScreen: LoadingScreen? = null
    var batch: SpriteBatch?=null
    var font: BitmapFont?=null

    var preferences=AppPreferences()

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        loadingScreen = LoadingScreen(this)
        setScreen(loadingScreen)
    }

    override fun dispose() {}

    fun changeScreen(screen: Int) {
        when (screen) {
            MENU -> {
                if (menuScreen == null) menuScreen = MenuScreen(this)
                this.setScreen(menuScreen)
            }
            PREFERENCES -> {
                if (preferencesScreen == null) preferencesScreen = PreferencesScreen(this)
                this.setScreen(preferencesScreen)
            }
            APPLICATION -> {
                if (mainScreen == null) mainScreen = MainScreen(this)
                this.setScreen(mainScreen)
            }
            ENDGAME -> {
                if (endScreen == null) endScreen = EndScreen(this)
                this.setScreen(endScreen)
            }
        }
    }

    companion object {

        val MENU = 0
        val PREFERENCES = 1
        val APPLICATION = 2
        val ENDGAME = 3
    }
}
