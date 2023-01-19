package com.Team7.Skyinvasion.ui.game.views.instructions

class DialogHelper {

    var counter = 0

    var isOpen = true

    fun getItemSize() = dialogList.size

    private val dialogList by lazy {
        mutableListOf<Dialog>().apply {
            add(Dialog("Halo Pejuang!. Senang rasanya kamu kembali setelah sekian lama. Seperti yang kamu ketahui, Bumi kita dalam ambang Kehancuran."))
            add(Dialog("Hal ini Tentunya merupakan tugas kita untuk menyelamatkan bumi kita dari invasi alien. Saya menganggap Anda ingat cara mengemudikan Sky Hunter. Tapi mari kita bahas lagi, oke?"))
            add(Dialog("Rotasikan Ponsel Kamu untuk mengontrol Sky Hunter.", InstructionType.TILT))
            add(Dialog("Kerja bagus. Namun kamu harus menghemat sumber daya karena sulit didapat akhir-akhir ini.", duration = 5000L))
            add(Dialog("Bagian Sudut kiri atas, Kamu akan menemukan informasi mengenai cadangan Amunisi Anda.",
                InstructionType.AMMO))
            add(Dialog(" Anda harus menghemat amunisi. Karena Setelah kosong, Anda tidak dapat mengisinya kembali dan anda bisa jadi Mixue",
                InstructionType.AmmoWarning, duration = 5000L))
            add(Dialog("Pada bagian bawah, Kamu akan Mengetahui kondisi kesehatan Sky Hunter Kamu.",
                InstructionType.HEALTH))
            add(Dialog("Tekan Layar untuk Menembak", InstructionType.FIRE))
            add(Dialog("Keren, anda hebat!", duration = 4000L))
            add(Dialog("Sebentar!, ada Sinyal SOS", duration = 4000L))
            add(Dialog("Kijang 1! Kijang 1! Saya menemukan eksistensi alien baru saja menembakkan misil dan lokasi kita telah disusupi.\n" +
                    "Sekarang, seluruh alien tahu kita di sini.",
                duration = 12000L))
            add(Dialog("Ada armada Alien sedang menuju ke arahmu. Habisi mereka secepat mungkin. Jangan Biarkan Mereka melewati mu atau bumi akan hancur!", duration = 5000L))
            add(Dialog("Saya hampir lupa, kamu tidak sepenuhnya tidak bisa mengisi ulang amunisi. Pastikan untuk mengumpulkan kapsul untuk mengumpulkan lebih banyak amunisi.",
                InstructionType.EnemySpotted))
            add(Dialog("Semoga Tuhan Menyertaimu, Pejuang", InstructionType.EnemyTranslated, duration = 3000L))
        }
    }

    fun getNextDialog(): Dialog? {
        return if (counter < dialogList.size && isOpen) {
            val dialog = dialogList[counter]
            counter++
            dialog
        } else {
            null
        }
    }

    fun setLock() {
        isOpen = false
    }

    fun removeLock() {
        isOpen = true
    }

    data class Dialog(
        val text: String,
        val type: InstructionType = InstructionType.TEXT,
        val duration: Long = 8000L,
    )

    enum class InstructionType {
        TEXT,
        AMMO,
        HEALTH,
        TILT,
        FIRE,
        EnemySpotted,
        EnemyTranslated,
        AmmoWarning
    }
}
