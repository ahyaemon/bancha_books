import Paragraph from "./basic/Paragraph.vue"

import MenuItemBlue from "./menuitem/MenuitemBlue.vue"
import MenuItemYellow from "./menuitem/MenuitemYellow.vue"
import MenuItemYellowFavorite from "./menuitem/MenuitemYellowFavorite.vue"

import Pankuzu from "./pankuzu/Pankuzu.vue"
import PankuzuItem from "./pankuzu/PankuzuItem.vue"
import PankuzuItemHere from "./pankuzu/PankuzuItemHere.vue"

import NavAnonymous from "./nav/NavAnonymous.vue"
import NavGeneral from "./nav/NavGeneral.vue"
import NavAdmin from "./nav/NavAdmin.vue"

import TitleGeneral from "./title/TitleGeneral.vue"
import TitleAdmin from "./title/TitleAdmin.vue"

import Table from "./table/Table.vue"
import TableHeader from "./table/TableHeader.vue"
import TableBody from "./table/TableBody.vue"
import Row from "./table/Row.vue"
import Cell from "./table/Cell.vue"

import Card from "./card/Card.vue"
import CardTitle from "./card/CardTitle.vue"
import CardBody from "./card/CardBody.vue"

import Warning from "./warning/Warning.vue"

import Main from "./layout/Main.vue"
import Footer from "./layout/Footer.vue"

const components =  {
    "b-p": Paragraph,

    "b-menuitem-blue": MenuItemBlue,
    "b-menuitem-yellow": MenuItemYellow,
    "b-manuitem-yellow-favorite": MenuItemYellowFavorite,

    "b-pankuzu": Pankuzu,
    "b-pankuzu-item": PankuzuItem,
    "b-pankuzu-item-here": PankuzuItemHere,

    "b-nav-anonymous": NavAnonymous,
    "b-nav-general": NavGeneral,
    "b-nav-admin": NavAdmin,

    "b-title-general": TitleGeneral,
    "b-title-admin": TitleAdmin,

    "b-table": Table,
    "b-table-header": TableHeader,
    "b-table-body": TableBody,
    "b-row": Row,
    "b-cell": Cell,

    "b-card": Card,
    "b-card-title": CardTitle,
    "b-catd-body": CardBody,

    "b-warning": Warning,

    "b-main": Main,
    "b-footer": Footer,
}

export default components
