object Builder {
  case class UserdCar(
                     make: String,
                     model: String,
                     kmDriven: Int,
                     yearOfManufacturing: Int,
                     hasGPS: Boolean = false,
                     hasAC: Boolean = false,
                     hasAirBags: Boolean = false,
                     hasABS: Boolean = false
                     ) {
    require(yearOfManufacturing > 1970, "Incorrect Year")
    require(checkMakeAndModel(), "Incorrect make and model")

    def checkMakeAndModel() = if (make == "Honda") {
      model == "CRV"
    } else if (make == "Toyota") {
      model == "Corolla"
    } else {
      true
    }
  }

  val usedCRV = UserdCar(make = "Honda", model = "CRV", kmDriven = 20000, yearOfManufacturing = 2008, hasABS = true, hasAirBags = true)

  val usedCorolla = usedCRV.copy(make = "Toyota", model = "Corolla")

  val usedCorolla1 = usedCRV.copy(make = "Toyota", model = "xxx")





}