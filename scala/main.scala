@main def main() =

  def reverseString(str: String): String =
    return str.reverse.toLowerCase().replaceAll("!", "")

  println(s"a.) ${reverseString("Hello, Scala!")}")

  def getSalaryPerMonth(
      yearSalarySum: Double,
      yearPremiumPercentage: Double,
      monthCompensation: Double
  ): Double =
    val account = 13
    var yearCompensationWithAccount =
      monthCompensation / (100 - account) * 100 * 12
    var yearPremiumWithoutAccount =
      (yearSalarySum - yearCompensationWithAccount) / 100 * yearPremiumPercentage
    var monthSalaryWithoutPremium =
      (yearSalarySum - yearPremiumWithoutAccount) / 12
    var monthSalaryWithoutAccount =
      monthSalaryWithoutPremium - (monthSalaryWithoutPremium / 100 * account) - monthCompensation

    // println(s"Compensation: ${monthCompensation} \n" +
    //   s"Compensation account: ${yearCompensationWithAccount / 12 / 100 * account } \n" +
    //   s"Premium: ${(yearPremiumWithoutAccount - (yearPremiumWithoutAccount / 100 * account)) / 12} \n" +
    //   s"Premium account: ${(yearPremiumWithoutAccount - (yearPremiumWithoutAccount - (yearPremiumWithoutAccount / 100 * account))) / 12} \n" +
    //   s"Salary account: ${(monthSalaryWithoutPremium / 100 * account) - (yearCompensationWithAccount / 12 - monthCompensation)} \n" +
    //   s"Salary: ${monthSalaryWithoutAccount - monthCompensation}")

    return Math.round(monthSalaryWithoutAccount - monthCompensation).toDouble

  var employeeSalary = getSalaryPerMonth(1200, 10, 20)
  println(s"b.) ${employeeSalary}")

  def salaryMean(salaryArr: List[Double]): Double =
    var mean: Double = salaryArr.sum / salaryArr.length

    return mean

  def salaryRatio(salary: Double, meanSalary: Double): String =
    var ratio = String.format("%.2f", salary / meanSalary * 100 - 100)

    return s"${ratio} %"

  // def checkArrSalaryRatio(salaryArr: List[Int], meanSalary: Double): String =
  //   var report = "salary ratio \n"
  //   for (salary <- salaryArr)
  //     report += s"${salaryRatio(salary, meanSalary)} \n"

  //   return report

  // println(s"c.) ${checkArrSalaryRatio(salaryArr , salaryMean(salaryArr))}" )

  var salaryArr = List(100.0, 150.0, 200.0, 80.0, 120.0, 75.0)
  println(s"c.) ${salaryRatio(employeeSalary, salaryMean(salaryArr))}")

  def changeEmployeeSalary(salary: Double, value: Double): Double =
    return (salary + value): Double

  salaryArr = salaryArr.appended(changeEmployeeSalary(employeeSalary, 20))
  println(s"d.) min salary: ${salaryArr.min}, max salary: ${salaryArr.max}")

  var newEmployeesSalary = List(350.0, 90.0)
  salaryArr = salaryArr.appendedAll(newEmployeesSalary).sorted
  println(s"e.) salaries: ${salaryArr}")

  var anotherEmployeeSalary = 130.0
  def addSalaryToSortedList(
      salary: Double,
      sortedList: List[Double]
  ): List[Double] =
    var newSortedList = List[Double]()
    var salaryAppend: Boolean = false
    for (el <- sortedList)
      if (el <= salary) {
        newSortedList = newSortedList.appended(el)
      } else if (el >= salary & salaryAppend == false) {
        newSortedList = newSortedList.appended(salary)
        newSortedList = newSortedList.appended(el)
        salaryAppend = true
      } else if (el >= salary & salaryAppend == true) {
        newSortedList = newSortedList.appended(el)
      }

    return newSortedList

  salaryArr = addSalaryToSortedList(anotherEmployeeSalary, salaryArr)
  println(s"f.) salaries: ${salaryArr}")

  var middleSalaryFork = List(120.0, 180.0)
  def getMiddleEmployeesIndexes(
      salaryFork: List[Double],
      salaryList: List[Double]
  ): List[Int] =
    var middleEmployeesIndexes = List[Int]()
    for (index <- salaryList.indices)
      if (
        salaryList(index) >= salaryFork(0) & salaryList(index) <= salaryFork(1)
      ) {
        middleEmployeesIndexes = middleEmployeesIndexes.appended(index)
      }

    return middleEmployeesIndexes

  println(
    s"g.) Middle indexes: ${getMiddleEmployeesIndexes(middleSalaryFork, salaryArr)}"
  )

  salaryArr = salaryArr.map(x => Math.round(x * 1.07).toDouble)

  println(s"h.) Salary + 7%: ${salaryArr}")
