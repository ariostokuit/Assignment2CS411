package org.csuf.cpsc411.assignment2_cs411

import java.util.*

data class Claim (var id : UUID = UUID.randomUUID(), var title : String?, var date : String?, var isSolved : Boolean? = false)