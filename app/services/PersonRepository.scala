package services

import models._
import play.api.libs.json._
import scala.collection.mutable.ListBuffer

@javax.inject.Singleton
class PersonRepository {

  var persons: ListBuffer[Person] = ListBuffer(
    Person(1, "john", 23, "Software Engineer"),
    Person(2, "carlos", 53, "Tech Engineer"),
    Person(3, "lucy", 22, "Software Engineer"),
    Person(4, "margarette", 45, "Data Scientist"),
    Person(5, "michel", 60, "Data Engineer")
  )

  def retrieve(): ListBuffer[Person] = persons

  def retrieve(id: Int): Person = persons.filter(p => p.id == id).head

  def create(username: String, age: Int, job: String): ListBuffer[Person] = {

    if ((persons.find(_.username == username)).isDefined) {
      println("Error, already eaxist")
    }

    // Add person
    persons.addOne(Person(5, username, age, job))

    return persons

  }

  def delete(id: Int): ListBuffer[Person] = {
    persons = persons.filter(p => p.id != id)
    persons
  }
}
