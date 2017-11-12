package blog.gamedevelopmentbox2dtutorial.views

import blog.gamedevelopmentbox2dtutorial.Box2DTutorial
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.utils.viewport.ScreenViewport

/**
 * Created by dastaniqbal on 12/11/2017.
 * dastanIqbal@marvelmedia.com
 * 12/11/2017 1:21
 */

class MenuScreen(private val parent: Box2DTutorial) : Screen, ChangeListener() {
    private val stage: Stage = Stage(ScreenViewport())
    private var exit: TextButton
    private var prefernces: TextButton
    private var newGame: TextButton

    init {
        Gdx.input.inputProcessor = stage
        stage.act(Math.min(Gdx.graphics.deltaTime, 1 / 30f))
        stage.draw()

        val table = Table()
        table.setFillParent(true)
        table.debug = true
        stage.addActor(table)

        val skin = Skin(Gdx.files.internal("skin/glassy-ui.json"))

        newGame = TextButton("New Game", skin)
        prefernces = TextButton("Preferences", skin)
        exit = TextButton("Exit", skin)

        table.add(newGame).fillX().uniformX()
        table.row().pad(10f, 0f, 10f, 0f)
        table.add(prefernces).fillX().uniformX()
        table.row()
        table.add(exit).fillX().uniformX()

        exit.addListener(this)
        newGame.addListener(this)
        prefernces.addListener(this)
    }
    override fun changed(event: ChangeEvent?, actor: Actor?) {
        when (actor) {
            prefernces -> parent.changeScreen(Box2DTutorial.PREFERENCES)
            newGame -> parent.changeScreen(Box2DTutorial.APPLICATION)
            exit -> Gdx.app.exit()
        }
    }
    override fun show() {

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
