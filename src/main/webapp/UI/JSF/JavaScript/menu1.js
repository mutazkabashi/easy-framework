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
var menuWidth="100px";
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
var fontStyle=" 11px Trebuchet MS, Tahoma";
var fontColor=["#ffffff","#ffffff"];
var fontDecoration=["none","none"];
var fontColorDisabled="#AAAAAA";

//--- Appearance
var menuBackColor="#D1FCCF";
var menuBackImage="";
var menuBackRepeat="repeat";
var menuBorderColor="#808080";
var menuBorderWidth=0;
var menuBorderStyle="none";

//--- Item Appearance
//var itemBackColor=["#C0C0C0","#808080"];
var itemBackColor=["#58a3ee","orange"];
var itemBackImage=["",""];
var itemBorderWidth=1;
var itemBorderColor=["#000000","#000000"];
var itemBorderStyle=["solid","solid"];
var itemSpacing=0;
var itemPadding="2px 5px 2px 10px";
var itemAlignTop="center";
var itemAlign="center";
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
var pathPrefix_img="";
var pathPrefix_link="";
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
    ["itemWidth=75px","itemBackColor=#58a3ee,orange","itemBorderWidth=0","fontStyle=bold 11px Tahoma","fontColor=#FFFFFF,#FFFFFF","itemBackImage=btn3_white.gif,btn5_blue.gif"],
];
var menuStyles = [
    ["menuBackColor=transparent","menuBorderWidth=0","itemSpacing=0","itemPadding=0px 5px 0px 5px"],
    ["smWidth=210px"]
];

var menuItems = [
    ["Home","http://mutaz/newsite/test.php", , ,"Home Page" , , "0", "0", ],
    ["Contact Us ","http://mutaz/newsite/contact_us.php", , , , , "0", "0", , ],
    ["Products ","http://mutaz/newsite/products.php", , ,"Our Products" , ,"0" , , , ],
        ["|Pentabank Core Banking","http://mutaz/newsite/product_info?product_name=pentabank", , , , , ,"1" , , ],
        ["|Micr Cheque Personalization System","http://mutaz/newsite/product_info?product_name=MCPS", , , , , , , , ],
        ["|MXP ATM Switch Host I/F","http://mutaz/newsite/product_info?product_name=MXP Host I/F", , , , , , , , ],
        ["|ATM Cash Management & Reconcilation","http://mutaz/newsite/product_info?product_name=ATM Management", , , , , , , , ],
        ["|ATM Card Issuing System","http://mutaz/newsite/product_info?product_name=ATM Card Issuing System", , , , , , , , ],
        ["|Virtual Branch System","http://mutaz/newsite/product_info?product_name=VBS", , , , , , , , ],
        ["|Islamic Investment Portofolio","http://mutaz/newsite/product_info?product_name=IIP", , , , , , , , ],
        ["|Islamic Investment Operation","http://mutaz/newsite/product_info?product_name=IIO", , , , , , , , ],
    ["Support","http://mutaz/newsite/forum/index.php", , , , , "0", "0", , ],
    ["Help Desk ","http://mutaz/newsite/", , , , , "0", "0", , ],
        ["|FAQ","http://mutaz/newsite/faq.php", , , , , , , , ],
        ["|Register Call","http://mutaz/newsite/faq.php", , , , , , , , ],
        ["|Call Status","http://mutaz/newsite/faq.php", , , , , , , , ],
    ["Downloads ","http://mutaz/newsite/", , , , , "0","0" , , ],
            ["|Demos","http://mutaz/newsite/downloads.php?cat_id=1", , , , , , , , ],
			["|Demos","http://mutaz/newsite/downloads.php?cat_id=1", , , , , , , , ],
            ["|Documentations","http://mutaz/newsite/", , , , , , , , ],
                ["||User Manuals","http://mutaz/newsite/downloads.php?cat_id=2", , , , , , , , ],
            ["|White Papers","http://mutaz/newsite/downloads.php?cat_id=3", , , , , , , , ],
            ["|Pentabank Bulletins","http://mutaz/newsite/downloads.php?cat_id=4", , , , , , , , ],
    ["Search ","http://mutaz/newsite/search.php", , , , , "0", "0", , ],
    ["Careers","http://mutaz/newsite/careers.php", , , , , "0", "0", , ],
    /*["Contact Us","viewpage.php?page_id=3", , , , , "0", , , ],*/
    ["Customer Forum   ","http://mutaz/newsite/forum/index.php", , , , , "0", "0", , ],
    ["SiteMap  ","http://mutaz/newsite/viewpage.php?page_id=4", , , , , "0", , , ],
];

dm_init();
