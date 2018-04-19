import play.api.mvc._
import akka.actor._
import javax.inject._
  
import actors.HelloActor

@Singleton
class Application @Inject() (system: ActorSystem,
                             cc:ControllerComponents)
  extends AbstractController(cc) {

  val helloActor = system.actorOf(HelloActor.props, "hello-actor")

  //...
}