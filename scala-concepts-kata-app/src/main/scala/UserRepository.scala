case class User(
  id: Int, 
  firstName: String,
  lastName: String,
  jobTitle: String,
  yearsExperience: Int,
  gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "Wyn", "Van Devanter", "Architect", 15, Some("male")),
                          2 -> User(2, "Pat", "Gibbons", "Sys Admin", 20, None)) 

  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}

// object Main extends App {

//   val user = UserRepository.findById(1)
//   println("Gender: " + user.gender.getOrElse("not specified"))

//   // Or via pattern matching
//   val gender = user.gender match {
//     case Some(gender) => gender
//     case None => "not specified"
//   }
  
// }