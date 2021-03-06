package labs.movieserver.datamodel


// MOVIE MODELS and Exceptions
case class Movie(id: String, title: String, year: Int, rating: Double)

case class MovieWithoutId(title: String, year: Int, rating: Double)

case class MovieNotFoundException(movieId: String) extends Exception(s"Not found movie with Id ${movieId}")

case class RequestFailed() extends Exception("Request failed!")


// USER MODELS and Exceptions
case class User(id: String, name: String, email: String )

case class UserId(title: String, name: String, email: String)

case class UserNotFoundException(userId: String) extends Exception(s"Not found User with Id ${userId}")


//  MOVIEQUOTE and Exceptions
case class MovieQuote(quoteId: String, movieId: String, quote: String )

case class MovieQuoteWithoutId(movieId: String, quote: String )

case class MovieQuoteNotFoundException(quote: String) extends Exception(s"Not found MovieQuote with Id ${quote}")
