package com.codehunters.repository.mapping

import com.codehunters.data.*
import com.codehunters.network.data.requestStudTour.DetailsEntity
import com.codehunters.network.data.requestStudTour.details.*

fun DetailsEntity.toDetailsInfoMapping() = DetailsInfo(
    mainInfo = mainInfo?.toMainInfo(),
    rules = rules?.toRulesInfo(),
    services = services?.toServicesInfo(),
    documents = documents
)

fun List<ServicesEntity>.toServicesInfo() = map {
    ServicesInfo(
        id = it.id,
        name = it.name,
        description = it.description,
        price = it.price,
        isFree = it.isFree
    )
}

fun RulesEntity.toRulesInfo() = RulesInfo(
    requiredUniDocuments = requiredUniDocuments,
    requiredStudentsDocuments = requiredStudentsDocuments,
    committee = committee.toCommitteeInfo()
)

fun MainInfoEntity.toMainInfo() = MainInfo(
    name = name,
    shortName = shortName,
    founderName = founderName,
    adminContacts = adminContacts,
    photoUrl = photoUrl,
    site = site,
    committee = committee.toCommitteeInfo(),
    city = city,
    region = region,
    district = district,
    street = street,
    houseNumber = houseNumber,
    coordinates = coordinates.toCoordsInfo(),
    minDays = minDays,
    maxDays = maxDays,
    photoUrls = photoUrls,
    mealPlan = mealPlan,
    dates = dates.toDatesInfo(),
    link = link,
    videos = videos,
    woS = woS,
    owner = owner.toInfo(),
    unit = unit.toInfo(),
    admin = admin.toInfo(),
    establishmentYear = establishmentYear,
    contactsName = contactsName,
    phone = phone,
    email = email,
    isFree = isFree,
    type = type,
    description = description,
    amount = amount,
    price = price
)

fun CommitteeEntity.toCommitteeInfo() = CommitteeInfo(
    email = email,
    phone = phone,
    name = name
)

fun CoordinatesEntity.toCoordsInfo() = CoordinatesInfo(latitude = latitude, longitude = longitude)

fun DatesEntity.toDatesInfo() = DatesInfo(from = from, to = to, isRegular = isRegular)

fun Entity.toInfo() = Info(
    name = name,
    position = position,
    phone = phone,
    email = email
)