package sandbox.lift.rest

import net.liftweb.http.PlainTextResponse
import net.liftweb.http.rest.RestHelper
import net.liftweb.http.Req
import net.liftweb.common.Full
import net.liftweb.http.InMemoryResponse

object StatusResponder extends RestHelper{

  serve {
    case req @ Req( AsInt(status) :: Nil, _ , _) =>
      InMemoryResponse(req.headers.toString.getBytes, Nil, Nil, status)
  }
}

object AsInt{
  def unapply(s: String) =
    try{
      Some(s.toInt)
    } catch {
      case _ => None
    }
}
