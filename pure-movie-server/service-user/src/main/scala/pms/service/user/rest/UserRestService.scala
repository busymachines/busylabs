package pms.service.user.rest

import cats.implicits._

import pms.effects._
import pms.http._
import pms.algebra.user._

import org.http4s._
import org.http4s.dsl._

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 26 Jun 2018
  *
  */
final class UserRestService[F[_]](
  private val userAlgebra: UserAlgebra[F],
)(
  implicit val F: Async[F],
) extends Http4sDsl[F] with UserServiceJSON {

  val userRestService: HttpService[F] = HttpService[F] {
    case GET -> Root / "user" / LongVar(userID) =>
      for {
        resp <- Ok(userAlgebra.findUser(UserID(userID))(??? : AuthCtx))
      } yield resp
  }

}