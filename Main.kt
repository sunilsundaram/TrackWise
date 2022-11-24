import java.util.*
import kotlin.collections.HashMap

// class for handling signup and login
//Sign up user Id checker
class SLUP constructor(choice: String) {
    var hashMap: HashMap<String, String> = HashMap<String, String>()
    var expenseMap: HashMap<String, HashMap<String,Float>> = HashMap<String,HashMap<String,Float>>()
    //var expenseName: HashMap<String, ArrayList<String>> = HashMap<String, ArrayList<String>>()
    fun logIn(): Any {
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--           Log In Page                                        --")
        println("--                                                              --")
        println("--                                                              --")
        println("--   Enter your User name:                                      --")
        println("--                                                              --")
        println("--                                                              --")
        println("--       press 1 to return to Main Menu                         --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        var sessionId = "-1214"
        val stringInput = readln()
        if(stringInput == "1"){
            this.mainMenu()
        }
        else if (hashMap.containsKey(stringInput)) {
            println("------------------------------------------------------------------")
            println("--                                                              --")
            println("--           Log In Page                                        --")
            println("--                                                              --")
            println("--                                                              --")
            println("           Enter your password for the account $stringInput     --")
            println("--                                                              --")
            println("--                                                              --")
            println("--       press 1 to return to Main Menu                         --")
            println("--                                                              --")
            println("--                                                              --")
            println("------------------------------------------------------------------")
            val activePass = readln()
            if (activePass == hashMap[stringInput]) {
                println("Welcome $stringInput")
                sessionId = stringInput
                //this.profilePage(sessionId)
            } else {
                println(" your password was incorrect, Please enter your details again")
                this.logIn()
            }
        } else {
            println("You do not have an account, Please sign up to create a new account")
            this.signUp()

        }
        return(Unit)
    }
    fun signUp() {
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--                                                              --")
        println("--       SignUp page                                            --")
        println("--                                                              --")
        println("-- Enter Your Preferred Username                                --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        val stringInput = readln()
        if(hashMap.containsKey(stringInput)) {
            println("------------------------------------------------------------------")
            println("--                                                              --")
            println("--                                                              --")
            println("--     SignUp page                                              --")
            println("--                                                              --")
            println("-- sorry this user name is already taken                        --")
            println("--                                                              --")
            println("--                                                              --")
            println("------------------------------------------------------------------")
            this.signUp()
        }
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--      SignUp page                                             --")
        println("Enter your Preferred password")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        val passwordOne = readln()
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--      SignUp page                                             --")
        println("-- Re-enter your password for confirmation                      --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        val passwordTwo = readln()
        if (passwordOne == passwordTwo) {
            hashMap[stringInput] = passwordTwo
            println("------------------------------------------------------------------")
            println("--                                                              --")
            println("--                                                              --")
            println("-- your new password was successful                             --")
            println("--                                                              --")
            println("--                                                              --")
            println("------------------------------------------------------------------")
            val logInn = this.logIn()
            println("directs to login page")

        } else {
            println("------------------------------------------------------------------")
            println("--                                                              --")
            println("--                                                              --")
            println("--  Your passwords did not match                                --")
            println("--                                                              --")
            println("--                                                              --")
            println("------------------------------------------------------------------")
            println("---   Please retry signup process                              ---")
            println("------------------------------------------------------------------")
            this.signUp()
        }
    }

    fun delete(sessionId:String){
        val temp = sessionId
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--  You want to delete the profile with the user name : $temp   --")
        println("--  Type the account's password to  Confirm deletion            --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        val keyword = readln()
        if(keyword == hashMap[temp]){
            hashMap.remove("$temp")
            println("Profile successfully deleted")
        }else{
            println(" Sorry the password you entered was incorrect. Please try again")
        }
        println("------------------------------------------------------------------")
        this.mainMenu()
    }
    fun logout(){
        println("-------------------------------------------------------------------")
        println("--        You have logged out successfully                       --")
        this.mainMenu()

    }

    fun expensePage(sessionId:String, flag:Int){
        var temp: java.util.HashMap<String, Float>? = expenseMap[sessionId]
        var fil = temp?.get("goal")
        var tot = temp?.get("total")
        var bal = temp?.get("balance")
        if (temp != null) {
            if((temp.size)>3){
                println("------------------------------------------------------------------")
                println("--                                                              --")
                println("==    $sessionId's Profile                                        ")
                println("==                                                                ")
                println("==    Your Preferred Budget: $fil                                 ")
                println("==    Your Total Expense: $tot                                    ")
                println("==    Your Total Balance: $bal                                    ")
                println("==                                                                ")
                println("==  your Trades:                                                  ")
                println("==           Item Name              Item Cost                     ")
                for((key,value)in temp){
                    if(key =="goal"){
                        continue
                    }else if(key == "balance"){
                        continue
                    }else if(key == "total"){
                        continue
                    }else{
                        println("==           $key  ------         $value $")
                    }
                }
                println("--                                                              --")
                println("--                                                              --")
                println("--                                                              --")
                println("--                                                              --")
                println("--       press 1 to return to profile page                      --")
                println("--                                                              --")
                println("------------------------------------------------------------------")
                if(flag == 1){
                    println("-- Enter the trade item name you want to delete or press 1 for profile page        --")
                    println("--------------------------------------------------------------------------------------")
                    val item = readln()
                    if(item == "1"){
                        this.profilePage(sessionId)
                    }else if(temp.containsKey(item)){
                        val price = temp[item]
                        var tot = temp["total"]
                        var bal = temp["balance"]
                        if (tot != null) {
                            tot = tot - price!!
                            temp.put("total",tot)
                        }
                        if(bal != null){
                            bal = bal + price!!
                            temp.put("balance", bal)
                        }
                        temp.remove(item)
                        println("-- Item successfully deleted   --------------------------------------------")
                        this.expensePage(sessionId, 0)
                    }else{
                        println("--  The item you choose doesn't exist, choose a valid purchase item to delete  --")
                        this.expensePage(sessionId,1)
                        println("--------------------------------------------------------------------------------------")

                    }
                }
            }else if((temp.size)==3){
                println("------------------------------------------------------------------")
                println("--                                                              --")
                println("==    $sessionId's Profile                                        ")
                println("==                                                                ")
                println("==    Your Preferred Budget: $fil                                 ")
                println("==    Your Total Expense: $tot                                    ")
                println("==    Your Total Balance: $bal                                    ")
                println("==    You do not have any trades                                --")
                println("==    Start adding trades from profile page                     --")
                println("--                                                              --")
                println("--                                                              --")
                println("--                                                              --")
                println("--     press 1 to return to profile page                        --")
                println("--                                                              --")
                println("------------------------------------------------------------------")
            }else{
                println("------------------------------------------------------------------")
                println("--                                                              --")
                println("--                                                              --")
                println("--                                                              --")
                println("--      You do not have any records to display,                 --")
                println("--     Start your profile by setting a budget                   --")
                println("--                                                              --")
                println("--                                                              --")
                println("--     press 1 to return to profile page                        --")
                println("--                                                              --")
                println("------------------------------------------------------------------")
            }
            println("press 1 to return to profile page")
            val clicker = readln()
            if(clicker == "1"){
                this.profilePage(sessionId)
            }else{
                println("Enter a valid entry")
                this.expensePage(sessionId,0)
            }
        }else{
            println("------------------------------------------------------------------")
            println("--                                                              --")
            println("--                                                              --")
            println("--                                                              --")
            println("--     You do not have any records to display,                  --")
            println("--   Start your profile by setting a budget                     --")
            println("--                                                              --")
            println("--                                                              --")
            println("--     press 1 to return to profile page                        --")
            println("--                                                              --")
            println("------------------------------------------------------------------")
            println("press 1 to return to profile page")
            val clicker = readln()
            if(clicker == "1"){
                this.profilePage(sessionId)
            }else{
                println("Enter a valid entry")
                this.expensePage(sessionId,0)
            }
        }

    }

    fun profilePage(sessionId: String) {
        println("------------------------------------------------------------------")
        println("--  $sessionId,'s Profile                                       --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                 Welcome, $sessionId                            ")
        println("--  Choose your favoured option from below:                     --")
        println("--         1  -   check your balance available for the month    --")
        println("--         2  -   To set expense limit                          --")
        println("--         3  -   To record a recent expense                    --")
        println("--         4  -   To check Total expenditure                    --")
        println("--         5  -   To delete an expense                          --")
        println("--         6  -   To delete you profile                         --")
        println("--         7  -   To Logout                                     --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        var pointer = readln()
        if(pointer == "1"){
            this.expensePage(sessionId,0)
            //   }else if(pointer == "2"){
            //       this.expenseLimit(sessionId)
            //    }else if(pointer == "3"){
            //       this.addExpense(sessionId)
        }else if(pointer == "4"){
            this.expensePage(sessionId,0)
        }else if(pointer == "5"){
            this.expensePage(sessionId,1)
            //  }else if(pointer == "6"){
            //      this.delete(sessionId)
        }else if(pointer == "7"){
            this.logout()
        }else{
            println("---------------------------------------------------------------")
            println("---     Invalid entry, enter a vaild selection              --")
            println("---------------------------------------------------------------")
            this.profilePage(sessionId)
        }

    }

    fun mainMenu(){
        println("------------------------------------------------------------------")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--           Hello Welcome to Plan Wise                         --")
        println("--       Your own financial planning partner                    --")
        println("--  Choose your favoured option from below:                     --")
        println("--         1  -   To sign Up (create a new profile)             --")
        println("--         2  -   To LogIn  (If you already have an account)    --")
        println("--      Press any other key To Exit the Program                 --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("--                                                              --")
        println("------------------------------------------------------------------")
        val reader = Scanner(System.`in`)
        print("Enter 1 for signUp and 2 for LogIn:")
        var integer: Int = reader.nextInt()
        println("------------------------------------------------------------------")
        if (integer == 2) {
            // val temp = this.logIn()
            println("directs to login page")
        } else if(integer == 1) {
            this.signUp()
        }
    }
}

fun main(args: Array<String>) {
    println("hello, type start to start the application")
    val stringInput = readln()
    if(stringInput == "start"){
        val objectVar = SLUP(stringInput)
        val temp = objectVar.mainMenu()
    }

    println("Program arguments: ${args.joinToString()}")
}


