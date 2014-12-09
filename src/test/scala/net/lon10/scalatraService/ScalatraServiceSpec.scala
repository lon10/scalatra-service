package net.lon10.scalatraService

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class ScalatraServiceSpec extends ScalatraSpec { def is =
  "GET / on ScalatraService"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[ScalatraService], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
