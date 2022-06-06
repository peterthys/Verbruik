package com.example.voer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.voer.DataBase.Jeton
import com.example.voer.DataBase.VoerViewModel
import com.example.voer.DataBase.Settings
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val PLAYER = "player"
const val COMPUTER = "computer"
const val WHITE = Color.WHITE
const val YELLOW = Color.YELLOW
const val RED = Color.RED
const val BLUE = Color.BLUE

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var gridView: GridView
    private lateinit var jetonArrayList: ArrayList<Jeton>
    private var combination4List: ArrayList<Combinations4> = ArrayList()
    private lateinit var jetonAdaptor: JetonAdaptor
    private lateinit var gameCalculator: GameCalculator


    private lateinit var mySettings: Settings

    private lateinit var mVoerViewModel: VoerViewModel
    private var initialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mVoerViewModel = ViewModelProvider(this).get(VoerViewModel::class.java)
        gridView = findViewById(R.id.grid_view)
        gridView.onItemClickListener = this


        mVoerViewModel.jetonList.observe(this, { jetons ->
            if (!initialized) {
                initializeJetons(jetons)
                initialized = true
            }
        })
        mVoerViewModel.settings.observe(this, {
            initializeSettings(it.firstOrNull())
        })

        startSpel()

    }

    private fun initializeSettings(settings: Settings?) {
        if (settings == null) {
            mySettings = Settings(PLAYER, WHITE, WHITE)
            mVoerViewModel.addSettings(mySettings)
        } else {
            mySettings = settings

        }
    }


    private fun initializeJetons(dbList: List<Jeton>) {
        if (dbList.isNotEmpty()) {
            jetonArrayList = ArrayList(dbList)
        } else {
            jetonArrayList = ArrayList()
            setJetonsList()
        }
        combination4List = setCombinatieList()

        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList)
        gridView.adapter = jetonAdaptor
        gameCalculator = GameCalculator(jetonArrayList, combination4List)
    }

    private fun setJetonsList(): ArrayList<Jeton> {
        var position = 0
        for (r: Int in 6 downTo 1) {
            for (k: Int in 1..7) {
                val jeton = Jeton(position, r, k, WHITE, "")
                jetonArrayList.add(jeton)
                insertJetonToDatabase(jeton)
                position++
            }
        }
        return jetonArrayList
    }

    private fun setCombinatieList(): ArrayList<Combinations4> {

        val cijfers1: List<Int> = listOf(
            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17, 21, 22, 23, 24, 28, 29, 30, 31, 35, 36, 37, 38
        )
        val cijfers2: List<Int> = listOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        )
        val cijfers3: List<Int> = listOf(
            3, 4, 5, 6, 10, 11, 12, 13, 17, 18, 19, 20
        )
        val cijfers4: List<Int> = listOf(
            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17
        )
        //Vier horizontaal
        for (i in cijfers1) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 1],
                jetonArrayList[i + 2],
                jetonArrayList[i + 3]
            )
            combination4List.add(comb4)
        }
        //Vier vertikaal
        for (i in cijfers2) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 7],
                jetonArrayList[i + 14],
                jetonArrayList[i + 21]
            )
            combination4List.add(comb4)
        }
        //Vier diagonaal stijgend
        for (i in cijfers3) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 6],
                jetonArrayList[i + 12],
                jetonArrayList[i + 18]
            )
            combination4List.add(comb4)
        }
        //Vier diagonaal dalend
        for (i in cijfers4) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 8],
                jetonArrayList[i + 16],
                jetonArrayList[i + 24]
            )
            combination4List.add(comb4)
        }
        return combination4List
    }


    fun startSpel() {

        val buttonHerstart: Button = findViewById(R.id.herstart_button)
        val ButtonGeel: Button = findViewById(R.id.radioButton_geel)
        val ButtonRood: Button = findViewById(R.id.radioButton_rood)
        val ButtonIkBegin: Button = findViewById(R.id.button_ik_begin)
        val ButtonComputerBegint: Button = findViewById(R.id.button_computer_begint)
        ButtonIkBegin.setVisibility(View.GONE)
        ButtonComputerBegint.setVisibility(View.GONE)
        textView.setTextColor(Color.BLACK)
        textView.setText("Welkom bij Vier op een rij !\nKies de kleur waarmee je wil spelen.")


        ButtonGeel.setOnClickListener {
//            colorPlayer = YELLOW
//            colorComputer = RED
            mySettings.colorComputer = RED
            mySettings.colorPlayer = YELLOW
            mVoerViewModel.updateSettings(mySettings)
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.VISIBLE)
            ButtonComputerBegint.setVisibility(View.VISIBLE)
            textView.setText("Kies wie begint.")
        }
        ButtonRood.setOnClickListener {
//            colorPlayer = RED
//            colorComputer = YELLOW
            mySettings.colorPlayer = RED
            mySettings.colorComputer = YELLOW
            mVoerViewModel.updateSettings(mySettings)
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.VISIBLE)
            ButtonComputerBegint.setVisibility(View.VISIBLE)
            textView.setText("Kies wie begint.")

        }

        ButtonIkBegin.setOnClickListener {
            textView.setText("\nPlaats je jeton")
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.GONE)
            ButtonComputerBegint.setVisibility(View.GONE)
            mySettings.whoseTurn = PLAYER
            mVoerViewModel.updateSettings(mySettings)
//            whoseTurn = PLAYER
        }
        ButtonComputerBegint.setOnClickListener {
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.GONE)
            ButtonComputerBegint.setVisibility(View.GONE)
            mySettings.whoseTurn = COMPUTER
            mVoerViewModel.updateSettings(mySettings)
//            GlobalScope.launch{
//                delay(3000L)
            firstJetonComputer()
        //}
        }
        buttonHerstart.setOnClickListener {
            for (jeton in jetonArrayList) {
                textView.setTextColor(Color.BLACK)
                textView.setText("Kies de kleur waarmee je wil spelen.")
                jeton.player = ""
                jeton.color = WHITE
                ButtonGeel.setVisibility(View.VISIBLE)
                ButtonRood.setVisibility(View.VISIBLE)
                ButtonIkBegin.setVisibility(View.GONE)
                ButtonComputerBegint.setVisibility(View.GONE)
                mySettings = Settings(COMPUTER, WHITE, WHITE)
                mVoerViewModel.updateSettings(mySettings)
                updateJetonToDatabase(jeton)
                jetonAdaptor.notifyDataSetChanged()
            }
            //  whoseTurn = COMPUTER
        }

    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val jeton: Jeton = jetonArrayList.get(position)
        if (mySettings.whoseTurn == "computer") {
            Toast.makeText(applicationContext, "Je bent niet aan zet !", Toast.LENGTH_LONG).show()
        } else
            controlAllreadyChoosen(jeton, position)
        val voer: String = gameCalculator.control4OnARow()
        if (voer == "player") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Jij hebt gewonnen!\n Proficiat")
            mySettings.whoseTurn = "nobody"
        }
        nextJetonComputer(mySettings)


        mySettings.whoseTurn = "player"

        val voer2 = gameCalculator.control4OnARow()

        if (voer2 == "computer") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Computer heeft gewonnen!")
            mySettings.whoseTurn = "nobody"
        }
    }

    fun controlAllreadyChoosen(jeton: Jeton, position: Int) {

        if (jeton.color == RED || jeton.color == YELLOW) {
            Toast.makeText(
                applicationContext,
                "Jeton is reeds bezet !\nMaak een andere keuze.",
                Toast.LENGTH_SHORT
            ).show()

        } else {
            val jetonPlayer = gameCalculator.setCorrectPlace(position)
            jetonPlayer.color = mySettings.colorPlayer
            jetonPlayer.player = PLAYER
            updateJetonToDatabase(jetonPlayer)
            jetonAdaptor.notifyDataSetChanged()
            mySettings.whoseTurn = "computer"
        }

    }

    fun firstJetonComputer(): Jeton {
        textView.setText("\n\naan het denken ...")
        Thread.sleep(3000)
        runBlocking{
            delay(5000L)
        }
        val randomGetal: Int = (3..5).random()
        val firstJeton = jetonArrayList[34 + randomGetal]
        firstJeton.color = mySettings.colorComputer
        firstJeton.player = COMPUTER
        textView.setText("\n\njouw beurt")
        mySettings.whoseTurn = PLAYER
        mVoerViewModel.updateSettings(mySettings)
        updateJetonToDatabase(firstJeton)
        jetonAdaptor.notifyDataSetChanged()
        return firstJeton

    }

    private fun nextJetonComputer(theSettings: Settings) {
        mySettings = theSettings
        if (mySettings.whoseTurn == COMPUTER) {
            val freeJetonsList: ArrayList<Jeton> = ArrayList()
            var jetonComputer = gameCalculator.control3OnARow()
            if (jetonComputer.player == "") {
                jetonComputer.player = COMPUTER
                jetonComputer.color = mySettings.colorComputer
                jetonArrayList[0].player = "null"
                mySettings.whoseTurn = PLAYER
                updateJetonToDatabase(jetonComputer)
                jetonAdaptor.notifyDataSetChanged()

            } else {
                jetonComputer = gameCalculator.control2OnARow()
                if (jetonComputer.player == "null") {
                    jetonComputer.player = "computer"
                    jetonComputer.color = mySettings.colorComputer
                    jetonArrayList[0].player = "null"
                    mySettings.whoseTurn = "player"
                    updateJetonToDatabase(jetonComputer)
                    jetonAdaptor.notifyDataSetChanged()
                } else {

                    for (jeton in jetonArrayList) {
                        if (jeton.color != RED && jeton.color != YELLOW) {
                            freeJetonsList.add(jeton)
                        }
                    }
                    val choosenJeton = (freeJetonsList).random()
                    jetonComputer = gameCalculator.setCorrectPlace(choosenJeton.position)
                    jetonComputer.player = "computer"
                    jetonComputer.color = mySettings.colorComputer
                    updateJetonToDatabase(jetonComputer)
                    jetonAdaptor.notifyDataSetChanged()
                    freeJetonsList.removeAll(freeJetonsList)
                }

            }
        } else {
        }
    }

    private fun insertJetonToDatabase(jeton: Jeton) {
        mVoerViewModel.addJeton(jeton)

    }

    private fun updateJetonToDatabase(jeton: Jeton) {
        mVoerViewModel.updateJeton(jeton)
    }
}
