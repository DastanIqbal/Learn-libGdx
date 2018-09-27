package blog.gamedevelopmentbox2dtutorial

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences

/**
 * Created by dastaniqbal on 12/11/2017.

 * 12/11/2017 3:32
 */
class AppPreferences {
    private val PREF_MUSIC_VOLUME = "volume"
    private val PREF_MUSIC_ENABLED = "music.enabled"
    private val PREF_SOUND_ENABLED = "sound.enabled"
    private val PREF_SOUND_VOLUME = "sound"
    private val PREFS_NAME = "b2dtut"

    protected fun getPrefs(): Preferences {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    fun getMusicVolume(): Float {
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f)
    }

    fun setMusicVolume(volume: Float) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume)
        getPrefs().flush()
    }

    fun getSoundVolume(): Float {
        return getPrefs().getFloat(PREF_SOUND_VOLUME, 0.5f)
    }

    fun setSoundVolume(volume: Float) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume)
        getPrefs().flush()
    }

    fun isMusicEnabled(): Boolean {
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true)
    }

    fun setMusicEnabled(musicEnabled: Boolean) {
        getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled)
        getPrefs().flush()
    }

    fun isSoundEffectsEnabled(): Boolean {
        return getPrefs().getBoolean(PREF_SOUND_ENABLED, true)
    }

    fun setSoundEffectsEnabled(soundEffectsEnabled: Boolean) {
        getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled)
        getPrefs().flush()
    }
}