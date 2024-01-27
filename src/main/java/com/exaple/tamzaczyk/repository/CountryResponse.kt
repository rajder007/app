package com.exaple.tamzaczyk.repository

data class CountryResponse(
    val name: Name,
    val capital: List<String>,
    val flags: Map<String, String>,
    val coatOfArms: Map<String, String>,
    val population: Int,
    val area: Float,
    val cca2: String,
    val region: String,
    val subregion: String
)

data class Name(
    val common: String,
    val official: String
)

//[{
//    "name": {
//        "common": "Christmas Island",
//        "official": "Territory of Christmas Island",
//        "nativeName": {
//        "eng": {
//        "official": "Territory of Christmas Island",
//        "common": "Christmas Island"
//    }
//    }
//    },
//    "tld": [".cx"],
//    "cca2": "CX",
//    "ccn3": "162",
//    "cca3": "CXR",
//    "independent": false,
//    "status": "officially-assigned",
//    "unMember": false,
//    "currencies": {
//        "AUD": {
//        "name": "Australian dollar",
//        "symbol": "$"
//    }
//    },
//    "idd": {
//        "root": "+6",
//        "suffixes": ["1"]
//    },
//    "capital": ["Flying Fish Cove"],
//    "altSpellings": ["CX", "Territory of Christmas Island"],
//    "region": "Oceania",
//    "subregion": "Australia and New Zealand",
//    "languages": {
//        "eng": "English"
//    },
//    "translations": {
//        "ara": {
//        "official": "جزيرة كريسماس",
//        "common": "جزيرة كريسماس"
//    },
//        "bre": {
//        "official": "Tiriad Enez Christmas",
//        "common": "Enez Christmas"
//    },
//        "ces": {
//        "official": "Teritorium Vánočního ostrova",
//        "common": "Vánoční ostrov"
//    },
//        "cym": {
//        "official": "Tiriogaeth yr Ynys y Nadolig",
//        "common": "Ynys y Nadolig"
//    },
//        "deu": {
//        "official": "Gebiet der Weihnachtsinsel",
//        "common": "Weihnachtsinsel"
//    },
//        "est": {
//        "official": "Jõulusaare ala",
//        "common": "Jõulusaar"
//    },
//        "fin": {
//        "official": "Joulusaaren alue",
//        "common": "Joulusaari"
//    },
//        "fra": {
//        "official": "Territoire de l'île Christmas",
//        "common": "Île Christmas"
//    },
//        "hrv": {
//        "official": "Teritorij Božićni otok",
//        "common": "Božićni otok"
//    },
//        "hun": {
//        "official": "Karácsony-sziget",
//        "common": "Karácsony-sziget"
//    },
//        "ita": {
//        "official": "Territorio di Christmas Island",
//        "common": "Isola di Natale"
//    },
//        "jpn": {
//        "official": "クリスマス島の領土",
//        "common": "クリスマス島"
//    },
//        "kor": {
//        "official": "크리스마스 섬",
//        "common": "크리스마스 섬"
//    },
//        "nld": {
//        "official": "Grondgebied van Christmas Island",
//        "common": "Christmaseiland"
//    },
//        "per": {
//        "official": "جزیرهٔ کریسمس",
//        "common": "جزیرهٔ کریسمس"
//    },
//        "pol": {
//        "official": "Wyspa Bożego Narodzenia",
//        "common": "Wyspa Bożego Narodzenia"
//    },
//        "por": {
//        "official": "Território da Ilha Christmas",
//        "common": "Ilha do Natal"
//    },
//        "rus": {
//        "official": "Территория острова Рождества",
//        "common": "Остров Рождества"
//    },
//        "slk": {
//        "official": "Teritórium Vianočného ostrova",
//        "common": "Vianočnú ostrov"
//    },
//        "spa": {
//        "official": "Territorio de la Isla de Navidad",
//        "common": "Isla de Navidad"
//    },
//        "srp": {
//        "official": "Божићно Острво",
//        "common": "Божићно Острво"
//    },
//        "swe": {
//        "official": "Julön",
//        "common": "Julön"
//    },
//        "tur": {
//        "official": "Christmas Adası",
//        "common": "Christmas Adası"
//    },
//        "urd": {
//        "official": "ریاستِ جزیرہ کرسمس",
//        "common": "جزیرہ کرسمس"
//    },
//        "zho": {
//        "official": "圣诞岛",
//        "common": "圣诞岛"
//    }
//    },
//    "latlng": [-10.5, 105.66666666],
//    "landlocked": false,
//    "area": 135.0,
//    "demonyms": {
//        "eng": {
//        "f": "Christmas Islander",
//        "m": "Christmas Islander"
//    }
//    },
//    "flag": "\uD83C\uDDE8\uD83C\uDDFD",
//    "maps": {
//        "googleMaps": "https://goo.gl/maps/ZC17hHsQZpShN5wk9",
//        "openStreetMaps": "https://www.openstreetmap.org/relation/6365444"
//    },
//    "population": 2072,
//    "car": {
//        "signs": ["AUS"],
//        "side": "left"
//    },
//    "timezones": ["UTC+07:00"],
//    "continents": ["Asia"],
//    "flags": {
//        "png": "https://flagcdn.com/w320/cx.png",
//        "svg": "https://flagcdn.com/cx.svg"
//    },
//    "coatOfArms": {
//        "png": "https://mainfacts.com/media/images/coats_of_arms/cx.png",
//        "svg": "https://mainfacts.com/media/images/coats_of_arms/cx.svg"
//    },
//    "startOfWeek": "monday",
//    "capitalInfo": {
//        "latlng": [-10.42, 105.68]
//    },
//    "postalCode": {
//        "format": "####",
//        "regex": "^(\\d{4})$"
//    }
//}, {
//    "name": {
//        "common": "Eritrea",
//        "official": "State of Eritrea",
//        "nativeName": {
//        "ara": {
//        "official": "دولة إرتريا",
//        "common": "إرتريا‎"
//    },
//        "eng": {
//        "official": "State of Eritrea",
//        "common": "Eritrea"
//    },
//        "tir": {
//        "official": "ሃገረ ኤርትራ",
//        "common": "ኤርትራ"
//    }
//    }
//    },
//    "tld": [".er"],
//    "cca2": "ER",
//    "ccn3": "232",
//    "cca3": "ERI",
//    "cioc": "ERI",
//    "independent": true,
//    "status": "officially-assigned",
//    "unMember": true,
//    "currencies": {
//        "ERN": {
//        "name": "Eritrean nakfa",
//        "symbol": "Nfk"
//    }
//    },
//    "idd": {
//        "root": "+2",
//        "suffixes": ["91"]
//    },
//    "capital": ["Asmara"],
//    "altSpellings": ["ER", "State of Eritrea", "ሃገረ ኤርትራ", "Dawlat Iritriyá", "ʾErtrā", "Iritriyā"],
//    "region": "Africa",
//    "subregion": "Eastern Africa",
//    "languages": {
//        "ara": "Arabic",
//        "eng": "English",
//        "tir": "Tigrinya"
//    },
//    "translations": {
//        "ara": {
//        "official": "دولة إريتريا",
//        "common": "إريتريا"
//    },
//        "bre": {
//        "official": "Stad Eritrea",
//        "common": "Eritrea"
//    },
//        "ces": {
//        "official": "Stát Eritrea",
//        "common": "Eritrea"
//    },
//        "cym": {
//        "official": "Gwladwriaeth Eritrea",
//        "common": "Eritrea"
//    },
//        "deu": {
//        "official": "Staat Eritrea",
//        "common": "Eritrea"
//    },
//        "est": {
//        "official": "Eritrea Riik",
//        "common": "Eritrea"
//    },
//        "fin": {
//        "official": "Eritrean valtio",
//        "common": "Eritrea"
//    },
//        "fra": {
//        "official": "État d'Érythrée",
//        "common": "Érythrée"
//    },
//        "hrv": {
//        "official": "Država Eritreji",
//        "common": "Eritreja"
//    },
//        "hun": {
//        "official": "Eritrea",
//        "common": "Eritrea"
//    },
//        "ita": {
//        "official": "Stato di Eritrea",
//        "common": "Eritrea"
//    },
//        "jpn": {
//        "official": "エリトリア国",
//        "common": "エリトリア"
//    },
//        "kor": {
//        "official": "에리트레아국",
//        "common": "에리트레아"
//    },
//        "nld": {
//        "official": "Staat Eritrea",
//        "common": "Eritrea"
//    },
//        "per": {
//        "official": "جمهوری اریتره",
//        "common": "اریتره"
//    },
//        "pol": {
//        "official": "Państwo Erytrea",
//        "common": "Erytrea"
//    },
//        "por": {
//        "official": "Estado da Eritreia",
//        "common": "Eritreia"
//    },
//        "rus": {
//        "official": "Государство Эритрея",
//        "common": "Эритрея"
//    },
//        "slk": {
//        "official": "Eritrejský štát",
//        "common": "Eritrea"
//    },
//        "spa": {
//        "official": "Estado de Eritrea",
//        "common": "Eritrea"
//    },
//        "srp": {
//        "official": "Држава Еритреја",
//        "common": "Еритреја"
//    },
//        "swe": {
//        "official": "Staten Eritrea",
//        "common": "Eritrea"
//    },
//        "tur": {
//        "official": "Eritre Devleti",
//        "common": "Eritre"
//    },
//        "urd": {
//        "official": "ریاستِ ارتریا",
//        "common": "ارتریا"
//    },
//        "zho": {
//        "official": "厄立特里亚",
//        "common": "厄立特里亚"
//    }
//    },
//    "latlng": [15.0, 39.0],
//    "landlocked": false,
//    "borders": ["DJI", "ETH", "SDN"],
//    "area": 117600.0,
//    "demonyms": {
//        "eng": {
//        "f": "Eritrean",
//        "m": "Eritrean"
//    },
//        "fra": {
//        "f": "Érythréenne",
//        "m": "Érythréen"
//    }
//    },
//    "flag": "\uD83C\uDDEA\uD83C\uDDF7",
//    "maps": {
//        "googleMaps": "https://goo.gl/maps/HRyqUpnPwwG6jY5j6",
//        "openStreetMaps": "https://www.openstreetmap.org/relation/296961"
//    },
//    "population": 5352000,
//    "fifa": "ERI",
//    "car": {
//        "signs": ["ER"],
//        "side": "right"
//    },
//    "timezones": ["UTC+03:00"],
//    "continents": ["Africa"],
//    "flags": {
//        "png": "https://flagcdn.com/w320/er.png",
//        "svg": "https://flagcdn.com/er.svg",
//        "alt": "The flag of Eritrea comprises three triangles — a large red isosceles triangle with its base spanning the hoist end and its apex at the midpoint on the fly end, and a green and blue right-angled triangle above and beneath the red triangle. On the hoist side of the red triangle is a golden vertical olive branch encircled by a golden olive wreath."
//    },
//    "coatOfArms": {
//        "png": "https://mainfacts.com/media/images/coats_of_arms/er.png",
//        "svg": "https://mainfacts.com/media/images/coats_of_arms/er.svg"
//    },
//    "startOfWeek": "monday",
//    "capitalInfo": {
//        "latlng": [15.33, 38.93]
//    }
//}, {
