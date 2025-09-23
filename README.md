Here’s an English version of the README for your assignment:

---

# Education System

In this exercise, we aim to connect and synchronize the university systems of **Shahid Beheshti University (SBU)** and **Sharif University of Technology (SUT)**.

## Interface: `EducationalInstitution`

* An **interface** containing only the method `displayInfo`, which must be implemented in its subclasses.

## Abstract Class: `University`

* Implements the program’s interface.
* **Properties**:

  * `name`: the name of the university
  * `studentCount`: the number of students
  * `tuitionFee`: the tuition fee
  * `students`: an array of enrolled students
* **Constructor**: initializes all properties.
* **Method**:

  * `transferStudent`: transfers a student from one university to another (given in the argument).

    * Checks if the student belongs to the source university.
    * Removes the student from the source list and adds them to the destination list.
    * Updates the student’s `university` property.
    * Returns `true` if successful, otherwise `false`.

## Class: `Student`

* Implements the program’s interface.
* **Properties**:

  * `name`: student’s name
  * `university`: student’s university
  * `balance`: student’s balance
* **Constructor**:

  * Accepts name, balance, and university.
  * Checks if the student has enough budget to pay the tuition fee.
  * If yes, enrolls the student in the university and updates their balance.
  * If not, prints `"Not Enough Balance"`.
* **Method**:

  * `displayInfo`: returns a string in the following format:

    ```
    Name: <student name>
    University: <university name>
    Balance: <balance>
    ```
* **Getters**: 3 getters must be implemented for the properties.

## Class: `SbuUniversity`

* Extends `University`.
* **Constructor**: calls the parent constructor.
* **Method**:

  * `displayInfo`: returns a string in the format:

    ```
    SBU University
    Tuition Fee: <fee>
    Student Count: <count>
    ```

    (tuition fee should be displayed with one decimal place).

## Class: `SutUniversity`

* Same as `SbuUniversity`, but in the `displayInfo` method, `"SUT University"` should be printed instead of `"SBU University"`.

---

### Final Output

All classes and the interface should be included in a single file named:

**`EducationSystem.java`**

---

Do you also want me to **write and format the full Java implementation** (`EducationSystem.java`) for you?
