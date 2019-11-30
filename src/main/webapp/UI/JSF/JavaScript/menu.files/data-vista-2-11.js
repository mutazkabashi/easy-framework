/*
   Deluxe Menu Data File
   Created by Deluxe Tuner v2.0
   http://deluxe-menu.com
*/


// -- Deluxe Tuner Style Names
var itemStylesNames=["Top Item",];
var menuStylesNames=["Top Menu",];
// -- End of Deluxe Tuner Style Names

//--- Common
var isHorizontal=1;
var smColumns=1;
var smOrientation=0;
var smViewType=0;
var dmRTL=0;
var pressedItem=-2;
var itemCursor="default";
var itemTarget="_self";
var statusString="link";
var blankImage="images/blank.gif";

//--- Dimensions
var menuWidth="";
var menuHeight="21px";
var smWidth="";
var smHeight="";

//--- Positioning
var absolutePos=0;
var posX="10";
var posY="10";
var topDX=0;
var topDY=1;
var DX=-5;
var DY=0;

//--- Font
var fontStyle="normal 11px Trebuchet MS, Tahoma";
var fontColor=["#000000","#FFFFFF"];
var fontDecoration=["none","none"];
var fontColorDisabled="#AAAAAA";

//--- Appearance
var menuBackColor="#D1FCCF";
var menuBackImage="";
var menuBackRepeat="repeat";
var menuBorderColor="#808080";
var menuBorderWidth=1;
var menuBorderStyle="solid";

//--- Item Appearance
var itemBackColor=["#C0C0C0","#808080"];
var itemBackImage=["",""];
var itemBorderWidth=1;
var itemBorderColor=["#808080","#808080"];
var itemBorderStyle=["solid","solid"];
var itemSpacing=0;
var itemPadding="2px 5px 2px 10px";
var itemAlignTop="left";
var itemAlign="left";
var subMenuAlign="";

//--- Icons
var iconTopWidth=16;
var iconTopHeight=16;
var iconWidth=16;
var iconHeight=16;
var arrowWidth=7;
var arrowHeight=7;
var arrowImageMain=["arrv_black.gif",""];
var arrowImageSub=["arr_black.gif","arr_white.gif"];

//--- Separators
var separatorImage="";
var separatorWidth="100%";
var separatorHeight="3";
var separatorAlignment="left";
var separatorVImage="";
var separatorVWidth="3";
var separatorVHeight="100%";
var separatorPadding="0px";

//--- Floatable Menu
var floatable=0;
var floatIterations=6;
var floatableX=1;
var floatableY=1;

//--- Movable Menu
var movable=0;
var moveWidth=12;
var moveHeight=20;
var moveColor="#DECA9A";
var moveImage="";
var moveCursor="move";
var smMovable=0;
var closeBtnW=15;
var closeBtnH=15;
var closeBtn="";

//--- Transitional Effects & Filters
var transparency="85";
var transition=30;
var transOptions="";
var transDuration=350;
var transDuration2=200;
var shadowLen=3;
var shadowColor="#B1B1B1";
var shadowTop=0;

//--- CSS Support (CSS-based Menu)
var cssStyle=0;
var cssSubmenu="";
var cssItem=["",""];
var cssItemText=["",""];

//--- Advanced
var dmObjectsCheck=0;
var saveNavigationPath=1;
var showByClick=0;
var noWrap=1;
var pathPrefix_img="http://abdu.byethost7.com/images/vista2/";
var pathPrefix_link="http://abdu.byethost7.com/";
var smShowPause=200;
var smHidePause=1000;
var smSmartScroll=1;
var smHideOnClick=1;
var dm_writeAll=1;

//--- AJAX-like Technology
var dmAJAX=0;
var dmAJAXCount=0;

//--- Dynamic Menu
var dynamic=0;

//--- Keystrokes Support
var keystrokes=0;
var dm_focus=1;
var dm_actKey=113;

var itemStyles = [
    ["itemWidth=92px","itemBackColor=transparent,transparent","itemBorderWidth=0","fontStyle=normal 11px Tahoma","fontColor=#1A3953,#000000","itemBackImage=btn3_white.gif,btn5_blue.gif"],
];
var menuStyles = [
    ["menuBackColor=transparent","menuBorderWidth=0","itemSpacing=1","itemPadding=0px 5px 0px 5px"],
    ["smWidth=210px"]
];

var menuItems = [

    ["Home","news.php", , ,"Home Page" , , "0", "0", ],
    ["About Us","viewpage.php?page_id=2", , , , , "0", "0", , ],
    ["Products","", , ,"Our Products" , ,"0" , , , ],
        ["|Pentabank Core Banking","articles.php?cat_id=1", , , , , ,"1" , , ],
        ["|Micr Cheque Personalization System","articles.php?cat_id=2", , , , , , , , ],
        ["|MXP ATM Switch Host I/F","articles.php?cat_id=3", , , , , , , , ],
        ["|ATM Cash Management & Reconcilation","articles.php?cat_id=4", , , , , , , , ],
        ["|Customer Credit Rating","articles.php?cat_id=5", , , , , , , , ],
        ["|Virtual Branch System","articles.php?cat_id=6", , , , , , , , ],
        ["|Islamic Investment Portofolio","articles.php?cat_id=7", , , , , , , , ],
        ["|Islamic Investment Operation","articles.php?cat_id=8", , , , , , , , ],
    ["Support","forum/index.php", , , , , "0", "0", , ],
    ["Help Desk","", , , , , "0", "0", , ],
        ["|FAQ","faq.php", , , , , , , , ],
        ["|Register Call","faq.php", , , , , , , , ],
        ["|Call Status","faq.php", , , , , , , , ],
    ["Downloads ","", , , , , "0","0" , , ],
            ["|Demos","downloads.php?cat_id=1", , , , , , , , ],
            ["|Documentations","", , , , , , , , ],
                ["||User Manuals","downloads.php?cat_id=2", , , , , , , , ],
            ["|White Papers","downloads.php?cat_id=3", , , , , , , , ],
            ["|Pentabank Bulletins","downloads.php?cat_id=4", , , , , , , , ],
    ["Knowledge Base","search.php", , , , , "0", "0", , ],
    ["Careers","viewpage.php?page_id=1", , , , , "0", "0", , ],
    ["Contact Us","viewpage.php?page_id=3", , , , , "0", , , ],
    ["Customer Forum","forum/index.php", , , , , "0", "0", , ],
    ["SiteMap","viewpage.php?page_id=4", , , , , "0", , , ],
];

dm_init();