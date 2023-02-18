package com.codehunters.network.mapping

import com.codehunters.network.data.requestStudTour.DetailsEntity
import com.codehunters.network.data.requestStudTour.details.*
import com.codehunters.network.data.response.ResponseData
import com.codehunters.network.data.response.ResponseLabsData
import com.codehunters.network.data.response.ResponseUniversityData

fun ResponseData?.toDetailsWithNesting() = DetailsEntity(
    mainInfo = MainInfoEntity(
        name = this?.mainInfo?.name.orEmpty(),
        shortName = this?.mainInfo?.shortName.orEmpty(),
        founderName = this?.mainInfo?.founderName.orEmpty(),
        adminContacts = this?.mainInfo?.adminContacts.orEmpty(),
        photoUrl = this?.mainInfo?.photoUrl.orEmpty(),
        site = this?.mainInfo?.site.orEmpty(),
        committee = this?.mainInfo?.committee.toCommittee(),
        city = this?.mainInfo?.city.orEmpty(),
        region = this?.mainInfo?.region.orEmpty(),
        district = this?.mainInfo?.district.orEmpty(),
        street = this?.mainInfo?.street.orEmpty(),
        houseNumber = this?.mainInfo?.houseNumber.orEmpty(),
        coordinates = this?.mainInfo?.coordinates.toCoords(),
        minDays = this?.mainInfo?.minDays.orEmpty(),
        maxDays = this?.mainInfo?.maxDays.orEmpty(),
        photoUrls = this?.mainInfo?.photosUrls ?: emptyList(),
        mealPlan = this?.mainInfo?.mealPlan.orEmpty(),
        isFree = this?.mainInfo?.isFree ?: false,
        type = this?.mainInfo?.type.orEmpty(),
        description = this?.mainInfo?.description.orEmpty(),
        amount = this?.mainInfo?.amount.orEmpty(),
        price = this?.mainInfo?.price.orEmpty(),
        dates = this?.mainInfo?.dates.toDates(),
        link = this?.mainInfo?.link.orEmpty(),
        videos = this?.mainInfo?.video ?: emptyList(),
        woS = this?.mainInfo?.woS.orEmpty(),
        owner = this?.mainInfo?.owner.toOwner(),
        unit = this?.mainInfo?.unit.toOwner(),
        admin = this?.mainInfo?.admin.toOwner(),
        establishmentYear = this?.mainInfo?.establishmentYear.orEmpty(),
        contactsName = this?.mainInfo?.contactsName.orEmpty(),
        phone = this?.mainInfo?.phone.orEmpty(),
        email = this?.mainInfo?.email.orEmpty(),
        committeeString = String()
    ),
    rules = RulesEntity(
        requiredUniDocuments = this?.rules?.requiredUniDocuments.orEmpty(),
        requiredStudentsDocuments = this?.rules?.requiredStudentsDocuments.orEmpty(),
        committee = this?.rules?.committee.toCommittee()
    ),
    documents = this?.documents,
    services = this?.services?.toServices()
)

fun ResponseData?.toDetails() = DetailsEntity(
    mainInfo = MainInfoEntity(
        name = this?.name.orEmpty(),
        shortName = this?.shortName.orEmpty(),
        founderName = this?.founderName.orEmpty(),
        adminContacts = this?.adminContacts.orEmpty(),
        photoUrl = this?.photoUrl.orEmpty(),
        site = this?.site.orEmpty(),
        committee = this?.committee.toCommittee(),
        city = this?.city.orEmpty(),
        region = this?.region.orEmpty(),
        district = this?.district.orEmpty(),
        street = this?.street.orEmpty(),
        houseNumber = this?.houseNumber.orEmpty(),
        coordinates = this?.coordinates.toCoords(),
        minDays = this?.minDays.orEmpty(),
        maxDays = this?.maxDays.orEmpty(),
        photoUrls = this?.photosUrls ?: emptyList(),
        mealPlan = this?.mealPlan.orEmpty(),
        isFree = this?.isFree ?: false,
        type = this?.type.orEmpty(),
        description = this?.description.orEmpty(),
        amount = this?.amount.orEmpty(),
        price = this?.price.orEmpty(),
        dates = this?.dates.toDates(),
        link = this?.link.orEmpty(),
        videos = this?.video ?: emptyList(),
        woS = this?.woS.orEmpty(),
        owner = this?.owner.toOwner(),
        unit = this?.unit.toOwner(),
        admin = this?.admin.toOwner(),
        establishmentYear = this?.establishmentYear.orEmpty(),
        contactsName = this?.contactsName.orEmpty(),
        phone = this?.phone.orEmpty(),
        email = this?.email.orEmpty(),
        committeeString = String()
    )
)

fun ResponseData?.toCoords() = CoordinatesEntity(
    latitude = this?.lat ?: 0F,
    longitude = this?.lng ?: 0F
)

fun ResponseData?.toCommittee() = CommitteeEntity(
    email = this?.email.orEmpty(),
    phone = this?.phone.orEmpty(),
    name = this?.name.orEmpty()
)

fun List<ResponseData>?.toServices() = this?.map { it.toService() }

fun ResponseData?.toService() = ServicesEntity(
    id = this?.id.orEmpty(),
    name = this?.name.orEmpty(),
    description = this?.description.orEmpty(),
    price = this?.price.orEmpty(),
    isFree = this?.isFree ?: false
)

fun ResponseData?.toDates() = DatesEntity(
    from = this?.from ?: 0L,
    to = this?.to ?: 0L,
    isRegular = this?.isRegular ?: false
)

fun ResponseData?.toOwner() = Entity(
    name = this?.name.orEmpty(),
    position = this?.position.orEmpty(),
    phone = this?.phone.orEmpty(),
    email = this?.email.orEmpty(),
)

fun ResponseUniversityData?.toDetails() = DetailsEntity(
    mainInfo = MainInfoEntity(
        name = this?.name.orEmpty(),
        shortName = this?.shortName.orEmpty(),
        founderName = this?.founderName.orEmpty(),
        adminContacts = this?.adminContacts.orEmpty(),
        photoUrl = this?.photoUrl.orEmpty(),
        site = this?.site.orEmpty(),
        committee = CommitteeEntity(String(), String(), String()),
        city = this?.city.orEmpty(),
        region = this?.region.orEmpty(),
        district = this?.district.orEmpty(),
        street = this?.street.orEmpty(),
        houseNumber = this?.houseNumber.orEmpty(),
        coordinates = this?.coordinates.toCoords(),
        minDays = this?.minDays.orEmpty(),
        maxDays = this?.maxDays.orEmpty(),
        photoUrls = this?.photosUrls ?: emptyList(),
        mealPlan = this?.mealPlan.orEmpty(),
        isFree = this?.isFree ?: false,
        type = this?.type.orEmpty(),
        description = this?.description.orEmpty(),
        amount = this?.amount.orEmpty(),
        price = this?.price.orEmpty(),
        dates = this?.dates.toDates(),
        link = this?.link.orEmpty(),
        videos = this?.video ?: emptyList(),
        woS = this?.woS.orEmpty(),
        owner = this?.owner.toOwner(),
        unit = this?.unit.toOwner(),
        admin = this?.admin.toOwner(),
        establishmentYear = this?.establishmentYear.orEmpty(),
        contactsName = this?.contactsName.orEmpty(),
        phone = this?.phone.orEmpty(),
        email = this?.email.orEmpty(),
        committeeString = String()
    )
)

fun ResponseUniversityData?.toCoords() = CoordinatesEntity(
    latitude = this?.lat ?: 0F,
    longitude = this?.lng ?: 0F
)

fun ResponseUniversityData?.toDates() = DatesEntity(
    from = this?.from ?: 0L,
    to = this?.to ?: 0L,
    isRegular = this?.isRegular ?: false
)

fun ResponseUniversityData?.toOwner() = Entity(
    name = this?.name.orEmpty(),
    position = this?.position.orEmpty(),
    phone = this?.phone.orEmpty(),
    email = this?.email.orEmpty(),
)

fun ResponseLabsData?.toDetails() = DetailsEntity(
    mainInfo = MainInfoEntity(
        name = this?.name.orEmpty(),
        shortName = this?.shortName.orEmpty(),
        founderName = this?.founderName.orEmpty(),
        adminContacts = this?.adminContacts.orEmpty(),
        photoUrl = this?.photoUrl.orEmpty(),
        site = this?.site.orEmpty(),
        committee = CommitteeEntity(String(), String(), String()),
        city = this?.city.orEmpty(),
        region = this?.region.orEmpty(),
        district = this?.district.orEmpty(),
        street = this?.street.orEmpty(),
        houseNumber = this?.houseNumber.orEmpty(),
        coordinates = this?.coordinates.toCoords(),
        minDays = this?.minDays.orEmpty(),
        maxDays = this?.maxDays.orEmpty(),
        photoUrls = this?.photosUrls ?: emptyList(),
        mealPlan = this?.mealPlan.orEmpty(),
        isFree = this?.isFree ?: false,
        type = this?.type.orEmpty(),
        description = this?.description.orEmpty(),
        amount = this?.amount.orEmpty(),
        price = this?.price.orEmpty(),
        dates = this?.dates.toDates(),
        link = this?.link.orEmpty(),
        videos = this?.video ?: emptyList(),
        woS = this?.woS.orEmpty(),
        owner = this?.owner.toOwner(),
        unit = this?.unit.toOwner(),
        admin = this?.admin.toOwner(),
        establishmentYear = this?.establishmentYear.orEmpty(),
        contactsName = this?.contactsName.orEmpty(),
        phone = this?.phone.orEmpty(),
        email = this?.email.orEmpty(),
        committeeString = String()
    )
)

fun ResponseLabsData?.toCoords() = CoordinatesEntity(
    latitude = this?.lat ?: 0F,
    longitude = this?.lng ?: 0F
)

fun ResponseLabsData?.toDates() = DatesEntity(
    from = this?.from ?: 0L,
    to = this?.to ?: 0L,
    isRegular = this?.isRegular ?: false
)

fun ResponseLabsData?.toOwner() = Entity(
    name = this?.name.orEmpty(),
    position = this?.position.orEmpty(),
    phone = this?.phone.orEmpty(),
    email = this?.email.orEmpty(),
)