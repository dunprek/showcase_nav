package testing.com.showcase_nav

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import testing.com.showcase_nav.materialTapTarget.MaterialTapTargetPrompt

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNavPrompt()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun showNavPrompt() {
        MaterialTapTargetPrompt.Builder(this)
//                .setIcon(R.drawable.ic_home_black_24dp)
                .setTarget(R.id.navigation_home)
                .setPrimaryText(R.string.title_show_case)
                .setSecondaryText(R.string.detail_show_case)
                .setBackgroundColour(resources.getColor(R.color.colorBackground))
                .setAnimationInterpolator(FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setPromptStateChangeListener(MaterialTapTargetPrompt.PromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_DISMISSED) {
//                        Toast.makeText(this, "YOU'VE DISMISSED", Toast.LENGTH_LONG).show()
                        showSeconPrompt()
                    }


                })
                .show()
    }


    private fun showSeconPrompt() {
        MaterialTapTargetPrompt.Builder(this)
//                .setIcon(R.drawable.ic_home_black_24dp)
                .setTarget(R.id.navigation_dashboard)
                .setPrimaryText(R.string.title_show_case)
                .setSecondaryText(R.string.detail_show_case)
                .setBackgroundColour(resources.getColor(R.color.colorBackground))
                .setAnimationInterpolator(FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setPromptStateChangeListener(MaterialTapTargetPrompt.PromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_DISMISSED) {
//                        Toast.makeText(this, "YOU'VE DISMISSED", Toast.LENGTH_LONG).show()
                        showThirdPrompt()
                    }


                })
                .show()
    }


    private fun showThirdPrompt() {
        MaterialTapTargetPrompt.Builder(this)
//                .setIcon(R.drawable.ic_home_black_24dp)
                .setTarget(R.id.navigation_notifications)
                .setPrimaryText(R.string.title_show_case)
                .setSecondaryText(R.string.detail_show_case)
                .setBackgroundColour(resources.getColor(R.color.colorBackground))
                .setAnimationInterpolator(FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setPromptStateChangeListener(MaterialTapTargetPrompt.PromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_DISMISSED) {
                        Toast.makeText(this, "YOU'VE DISMISSED", Toast.LENGTH_LONG).show()
                    }


                })
                .show()
    }

}
