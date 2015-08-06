package pl.jan

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class Sample07flatMap {

  def sendPacketToEuropeAndBackII(): Unit = {
    val socket = Socket()
    val packet: Future[Array[Byte]] = socket.readFromMemory()

    // handling future result
    packet onComplete {
      case Success(p) => {
        val confirmation: Future[Array[Byte]] = socket.sendToEurope(p)
        ???
      }
      case Failure(t) => ???
    }
  }

  def sendPacketToEuropeAndBackIII(): Unit = {
    val socket = Socket()
    val packet: Future[Array[Byte]] = socket.readFromMemory()

    val confirmation: Future[Array[Byte]] = packet.flatMap(socket.sendToEurope(_))
  }
}

object Socket {
  def apply(): Socket = new Socket() {}
}

trait Socket {

  def readFromMemory(): Future[Array[Byte]] = {
    Future {
      Array[Byte](192.toByte, 168.toByte, 1, 9)
    }
  }

  def sendToEurope(packet: Array[Byte]): Future[Array[Byte]] = {
    Future {
      Array[Byte](192.toByte, 168.toByte, 1, 9)
    }
  }
}