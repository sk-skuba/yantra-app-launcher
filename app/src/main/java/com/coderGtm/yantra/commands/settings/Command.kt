package com.coderGtm.yantra.commands.settings

import android.content.Intent
import com.coderGtm.yantra.activities.MainActivity
import com.coderGtm.yantra.activities.SettingsActivity
import com.coderGtm.yantra.blueprints.BaseCommand
import com.coderGtm.yantra.models.CommandMetadata
import com.coderGtm.yantra.terminal.Terminal

class Command(terminal: Terminal) : BaseCommand(terminal) {
    override val metadata = CommandMetadata(
        name = "settings",
        helpTitle = "settings",
        description = "Launches Settings for Yantra Launcher."
    )

    override fun execute(command: String) {
        val args = command.split(" ")
        if (args.size > 1) {
            output("'settings' command does not take any parameters", terminal.theme.errorTextColor)
            return
        }
        val mainAct = terminal.activity as MainActivity
        mainAct.yantraSettingsLauncher.launch(Intent(terminal.activity, SettingsActivity::class.java))
    }
}