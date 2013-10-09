package sandbox.lift

import net.liftweb._
import http._
import sitemap._
import util._
import common._
import Loc._

class Boot extends Bootable {
  def boot {

    LiftRules.addToPackages("sandbox.lift")
    LiftRules.statelessDispatch.append(rest.StatusResponder)
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    LiftRules.stripComments.default.set(() => false)

    LiftRules.htmlProperties.default.set((r: Req) =>
      XHtmlInHtml5OutProperties(r.userAgent)
    )
  }
}
