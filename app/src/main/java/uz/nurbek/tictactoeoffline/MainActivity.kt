package uz.nurbek.tictactoeoffline

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var disabledBtnIds = ArrayList<Int>()
    private var activePalyer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        restartBtn.setOnClickListener { restartGame() }
    }

    fun btnClick(view: View) {
        val btnSelect = view as Button
        var someId = 0
        when (btnSelect.id) {
            R.id.btn1 -> someId = 1
            R.id.btn2 -> someId = 2
            R.id.btn3 -> someId = 3
            R.id.btn4 -> someId = 4
            R.id.btn5 -> someId = 5
            R.id.btn6 -> someId = 6
            R.id.btn7 -> someId = 7
            R.id.btn8 -> someId = 8
            R.id.btn9 -> someId = 9
        }
        playGame(someId, btnSelect)
    }

    private fun playGame(someId: Int, btnSelected: Button) {
        if (activePalyer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(someId)
            activePalyer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(someId)
            activePalyer = 1
        }
        btnSelected.isEnabled = false
        disabledBtnIds.add(someId)
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1

        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1

        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1

        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1

        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1

        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1

        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        // left X
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1

        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2

        // right X
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1

        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        if (winner != -1)
            win(winner)
        else
            isDraw()
    }

    private fun isDraw() {
        if (disabledBtnIds.contains(1) && disabledBtnIds.contains(2) && disabledBtnIds.contains(3)
            && disabledBtnIds.contains(4) && disabledBtnIds.contains(5) && disabledBtnIds.contains(6)
            && disabledBtnIds.contains(7) && disabledBtnIds.contains(8) && disabledBtnIds.contains(9)
        ) {
            resultTv.text = "DRAW"
            gameOff()
        }
    }

    private fun win(winedPlayer: Int) {
        if (winedPlayer == 1)
            resultTv.text = "Player 1 win this game"
        else
            resultTv.text = "Player 2 win this game"

        gameOff()
    }

    private fun gameOff() {
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false
        restartBtn.visibility = View.VISIBLE
    }

    private fun restartGame() {
        restartBtn.visibility = View.GONE
        resultTv.text = ""
        player1.clear()
        player2.clear()
        disabledBtnIds.clear()

        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true

        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        btn1.setBackgroundColor(resources.getColor(R.color.col_first))
        btn2.setBackgroundColor(resources.getColor(R.color.col_first))
        btn3.setBackgroundColor(resources.getColor(R.color.col_first))
        btn4.setBackgroundColor(resources.getColor(R.color.col_first))
        btn5.setBackgroundColor(resources.getColor(R.color.col_first))
        btn6.setBackgroundColor(resources.getColor(R.color.col_first))
        btn7.setBackgroundColor(resources.getColor(R.color.col_first))
        btn8.setBackgroundColor(resources.getColor(R.color.col_first))
        btn9.setBackgroundColor(resources.getColor(R.color.col_first))
    }

}