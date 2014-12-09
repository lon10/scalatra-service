import com.mongodb.casbah.Imports._
import net.lon10.scalatraService.controllers.StorageController
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    val mongoClient = MongoClient("localhost", 27017)
    val storageCollection = mongoClient("scalatra_simple_service")("storage")

    context.mount(new StorageController(storageCollection), "/")
  }
}