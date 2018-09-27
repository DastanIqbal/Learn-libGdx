package blog.gamedevelopmentbox2dtutorial.views

import blog.gamedevelopmentbox2dtutorial.Box2DTutorial
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.utils.viewport.ScreenViewport

/**
 * Created by dastaniqbal on 12/11/2017.

 * 12/11/2017 1:21
 */

class PreferencesScreen(private val parent: Box2DTutorial) : Screen {
    var stage: Stage = Stage(ScreenViewport())
    val skin = Skin(Gdx.files.internal("skin/glassy-ui.json"))

    init {
        stage.clear()
        stage.act(Math.min(Gdx.graphics.deltaTime, 1 / 30f))
        stage.draw()

        val table = Table()
        table.setFillParent(true)
        //table.debug = true
        stage.addActor(table)


        //volume
        val volumeMusicSlider = Slider(0f, 1f, 0.1f, false, skin)
        volumeMusicSlider.value = parent.preferences.getMusicVolume()
        volumeMusicSlider.addListener {
            parent.preferences.setMusicVolume(volumeMusicSlider.value)
            false
        }

        //soundEffect
        val volumeSoundSlider = Slider(0f, 1f, 0.1f, false, skin)
        volumeSoundSlider.value = parent.preferences.getSoundVolume()
        volumeSoundSlider.addListener {
            parent.preferences.setSoundVolume(volumeSoundSlider.value)
            false
        }

        //music
        val musicCheckBox = CheckBox(null, skin)
        musicCheckBox.isChecked = parent.preferences.isMusicEnabled()
        musicCheckBox.addListener {
            parent.preferences.setMusicEnabled(musicCheckBox.isChecked)
            false
        }

        //sound
        val soundCheckBox = CheckBox(null, skin)
        soundCheckBox.isChecked = parent.preferences.isSoundEffectsEnabled()
        soundCheckBox.addListener {
            parent.preferences.setSoundEffectsEnabled(soundCheckBox.isChecked)
            false
        }

        //back
        val backButton = TextButton("Back", skin, "small")
        backButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                parent.changeScreen(Box2DTutorial.MENU)
            }
        })

        val titleLabel = Label("Preferences", skin)
        val volumeMusicLabel = Label("Music Volume", skin)
        val volumeSoundLabel = Label("Sound Volume", skin)
        val musicOnOffLabel = Label("Music", skin)
        val soundOnOffLabel = Label("Sound", skin)

        table.add(titleLabel).colspan(2)
        table.row()
        table.add(volumeMusicLabel).left()
        table.add(volumeMusicSlider)
        table.row()
        table.add(musicOnOffLabel).left()
        table.add(musicCheckBox)
        table.row()
        table.add(volumeSoundLabel).left()
        table.add(volumeSoundSlider).left()
        table.row()
        table.add(soundOnOffLabel).left()
        table.add(soundCheckBox)
        table.row()
        table.add(backButton).colspan(2)
    }

    override fun show() {
        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.deltaTime, 1 / 30f))
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        // change the stage's viewport when teh screen size is changed
        stage.viewport.update(width, height, true)
    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }

    override fun dispose() {
        // dispose of assets when not needed anymore
        stage.dispose()
    }
}
