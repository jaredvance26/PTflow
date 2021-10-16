var patients = mutableMapOf(
    "Jared" to mutableListOf<String>("SLR", "SAQ", "LAQ"),
    "Bob" to mutableListOf<String>("3-way hip", "SLR", "TKE"),
    "Braden" to mutableListOf<String>("Tandem Balance", "SLS", "STS"),
    "Susie" to mutableListOf<String>("Wrist Flex", "Wrist Ext", "Curls")
)

fun main() {
    // Options for menu

    var option = -1

    while (option !== 4) {
        menu()
        option = readLine()!!.toInt()

        if (option==1) patientList()
        if (option==2) addPatient()
        if (option==3) removePatient()
    }


    if (option==4) println("Exiting")
    else println("Invalid response, exiting")
}

// Menu of options
fun menu() {
    println("--------Menu--------")
    println("1: View Patient(s)")
    println("2: Add Patient ")
    println("3: Delete Patient(s)")
    println("4: Exit")
    println("---------------------")
}

fun patientList() {

    for(patient in patients.keys) {
        println(patient)
    }
    println("Which patient would you like to work with? ")

    //View Patient's exercises
    var patient = readLine()!!.toString()
    patient = patient.capitalize()

    if (patient in patients.keys) {
        println()
        println(patient)
        println("-------------------------")


        println(patients.get("$patient"))
        println()
    }
    else {
        println("$patient does not exist")
    }



}
// Function to add patients to list
fun addPatient() {
    // list of exercises
    var program = mutableListOf<String>()

    // get name of patient
    println("What is the name of the patient: ")
    var patient = readLine()!!.toString()
    patient = patient.capitalize()

    // create exercise program
    println("What exercises would you like to add?")
    var exOne = readLine()!!.toString()
    program.add(exOne)
    var ex = ""
    while (ex != "done") {

        println("Enter exercise: ")
        println("Enter 'done' when finished")
        ex = readLine()!!.toString()
        if (ex != "done") {
            program.add(ex)
        }
        patients.put("$patient", program)
    }

}

// Remove patient from list
fun removePatient() {
    println("-------------------------")
    for (patient in patients.keys) {
        println(patient)
    }
    println("-------------------------")
    println("Which patient would you like to remove?")
    var removal = readLine()!!.toString()
    removal = removal.capitalize()

    patients.remove("$removal")

    println("$removal has been removed")
}










