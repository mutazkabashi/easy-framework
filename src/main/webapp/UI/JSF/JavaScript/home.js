/*
home.js javascript for Cisco homepage
$Revision: 1.4 $
*/

/* - cisco code */

function global_openCdcPopup ( url, width, height ) {
  if ( isNaN(parseInt(width)) ) { width=550; }
  else { width=parseInt(width); }
  if ( isNaN(parseInt(height)) ) {height=550; }
  else { height=parseInt(height); }
  var windowparms = "status=yes,scrollbars=yes,resizable=yes,width="+width+",height="+height;
  var popup = window.open ( url, "globalCDCpopup", windowparms);
  if (popup) popup.focus();
}


 function addToWindowOnLoad(funct){
 	var oldOnload = window.onload;
 	if (typeof window.onload != 'function') {
 		window.onload = funct;
 	}
 	else {
 		window.onload = function() {
 			oldOnload();
 			funct();
     	};
     }
 }


var search_checkClearCount = 0;
function checkClear(e, input,defaultPhrase) {
  var keynum;
  if(window.event) {
	keynum = e.keyCode;
  } else if(e.which) {
	keynum = e.which;
  }
  if ( !search_checkClearCount && keynum !=9  && input.value == defaultPhrase){
	input.value = "";
	search_checkClearCount++;
  }
}



/* - param set for lc.js - */
var vs_pt = true;

/**
 *  lc.js
   *     uses image request not http_request
   *
   *  Revision: 1.5
 */

/*---------------------------------------------------------------------------------------------------*/
var vs_imgArr=new Array(),vs_hif=-1;
for(var i=0;i<10;i++){
	vs_imgArr[i]=new Image();
}
function vs_Q(a){
	vs_hif++;
	if(vs_hif>10){
		vs_hif=0;
	}
	vs_imgArr[vs_hif]="";
	vs_imgArr[vs_hif]=new Image();
	vs_imgArr[vs_hif].src=a;
}
/*---------------------------------------------------------------------------------------------------*/

//var vs_getdomain = ""; //for root-relative url
var vs_getdomain="http://www.cisco.com"; // example for absolute url
var vs_filename = vs_getdomain + "/swa/j/zag2_vs_log1.asc?Log=1";
function vs_makeExit(link) {
  return function() {
    //var method = "POST";
    var method = "GET";

    var lhref = "&link=" + escape(link.href);
    var lname = "&linkname=" + escape(link.name);
    var theText = link.text ? link.text : link.innerText;
    var ltext = "&linktext=" + theText;
    var dref = "&title=" + document.title;
    var dlink = "&basepage=" + window.location.href;
    var cb = "&cb=" + (new Date()).getTime();
    var reqUrl = vs_filename + lhref + lname + ltext + dref + dlink + cb;
    vs_Q(reqUrl);
    return true;
  }
}

function vs_makeImg(link) {
  //var method = "POST";
  var method = "GET";

  var lsrc = "&image=" + escape(link.src);
  var ltext = "&imagetext=" + escape(link.alt);
  var lname = "&imagename=" + escape(link.name);
  var dref = "&title=" + document.title;
  var dlink = "&basepage=" + window.location.href;
  var cb = "&cb=" + (new Date()).getTime();
  var reqUrl = vs_filename + lsrc + ltext + lname + dref + dlink + cb;
  vs_Q(reqUrl);

  return true;
}

function vs_makeSubmit(link) {
  //var method = "POST";
  var method = "GET";

  var lname = "&linkname=" + escape(link.name);
  var dref = "&title=" + document.title;
  var dlink = "&basepage=" + window.location.href;
  var cb = "&cb=" + (new Date()).getTime();
  var reqUrl = vs_filename + lname + dref + dlink + cb;
  vs_Q(reqUrl);
  return true;
}
function vs_pageTag() {
  //var method = "POST";
  var method = "GET";

  var dref = "&title=" + document.title;
  var dlink = "&basepage=" + window.location.href;
  var cb = "&cb=" + (new Date()).getTime();
  var local_vars = "";
  if (typeof vs_vars != "undefined") {
    if (vs_vars) {
      local_vars = "&" + vs_vars;
    }
  }
  var reqUrl = vs_filename + dref + dlink + local_vars + cb;
  vs_Q(reqUrl);

  return true;
}

var vs_tempFunction = function() {
  if (typeof vs_pt != "undefined") {
    if (vs_pt) {
      vs_pageTag();
    }
  }
  // Get all of the a tags
  var o = document.getElementsByTagName("a");
  // Loop through all of the links
  for (i = 0; i < o.length; i++) {
    // Grab the rel attribute values
    if (anchs = o[i].getAttribute("rel")) {
      // If there is more than one value of rel, we need to split it
      var rels = anchs.split(" ");
      // Loop through all of the values of the rel attribute
      for (j = 0; j < rels.length; j++) {
        // If we found an exit link
        if (rels[j] == "exit") {
          // Make a new function to attach to the link
          exitLinkFunction = vs_makeExit(o[i]);
          // Attach the function to the onclick event of the link we found.
          o[i].onmousedown = exitLinkFunction;
        }
      }
    }
  }

  // Get all of the area tags
  var p = document.getElementsByTagName("area");
  // Loop through all of the links
  for (i = 0; i < p.length; i++) {
    // Grab the rel attribute values
    if (anchs = p[i].getAttribute("rel")) {
      // If there is more than one value of rel, we need to split it
      var arearels = anchs.split(" ");
      // Loop through all of the values of the rel attribute
      for (j = 0; j < arearels.length; j++) {
        // If we found an exit link
        if (arearels[j] == "exit") {
          // Make a new function to attach to the link
          exitLinkFunction = vs_makeExit(p[i]);
          // Attach the function to the onclick event of the link we found.
          p[i].onclick = exitLinkFunction;
        }
      }
    }
  }
}

addToWindowOnLoad(vs_tempFunction);




/* - dropdowns - */
var d=document;
var ddSwitch = 0; // initializes menus set to off

function ddInit(){
    if (d.layers) { // Netscape
        d.captureEvents(Event.ONMOUSEMOVE);
        d.onmousemove=captureMousePosition;
    } else if (d.getElementById || d.all){ // IE or Mozilla
        d.onmousemove=captureMousePosition;
    }
}

function ddDisplaySelect(){
    /* grab ID names of all side-parcels with "nojs" and switch out with "js" */
    ddCount = d.getElementsByTagName('div');
    for(i=0;i<ddCount.length;i++){
        if(ddCount[i].className == 'nojs'){ ddHide(ddCount[i].id); }
        if(ddCount[i].className == 'js'){ ddShow(ddCount[i].id); }
    }
}
var yMousePos=0;
var yMousePosMin=0;
var yMousePosMax=0;
function captureMousePosition(e) {
   if (d.all) {
            yMousePos = window.event.y+document.body.scrollTop;
            yMousePosMin = d.body.scrollTop;
            yMousePosMax = d.body.clientHeight+d.body.scrollTop;
        } else if (d.getElementById || d.layers){
            // Mozilla, FF, & Netscape work the same in this regard
            yMousePos = e.pageY;
            yMousePosMin = window.pageYOffset;
            yMousePosMax = window.innerHeight+window.pageYOffset;
    }
}
function ddShow(menu){
    d.getElementById(menu).style.display="block";
}
function ddHide(menu){
    d.getElementById(menu).style.display="none";
}
function ddHideAll(){
    var ddFound = ddFind();
    for (i=0;i<ddFound.length;i++){
        if(d.getElementById(ddFound[i]).style.display=="block") { ddHide(ddFound[i]);}
    }
}
function ddDir(menu){
        // Fixes slow computer redraw problem
            d.getElementById(menu).style.left="-10000px";
            ddShow(menu);
        /* if IE */
        if (d.all){
            ddMenuSpaceAvail=d.documentElement.clientHeight-yMousePos;
        } else {
            ddMenuSpaceAvail=yMousePosMax-yMousePos;
        }

        if ((d.getElementById(menu).offsetHeight<ddMenuSpaceAvail) || (ddMenuSpaceAvail>(yMousePos-yMousePosMin))){ /* checks if room to open down */
            d.getElementById(menu).style.top="-1px";
        } else { /* opens up */
            d.getElementById(menu).style.top = (2-(d.getElementById(menu+'Box').offsetHeight + d.getElementById(menu).offsetHeight))+'px';
        }
        ddHide(menu);
        d.getElementById(menu).style.left="0px";
}

function ddFind(){
    /* grab ID names of all side-parcels with selectBoxes */
    ddCount = d.getElementsByTagName("div");
    j=0;
    var ddFound = new Array();
    for(i=0;i<ddCount.length;i++){
        if(ddCount[i].className == 'selectBox'){
            // assuming parent div class is same as child minus 3 letter ext
            ddFound[j] = ddCount[i].id.substring(0, (ddCount[i].id.length-3));
            j++;
        }
    }
    return ddFound;
}

function ddToggle(menu, e){
    /* kill further events */
    e.cancelBubble=true;

    // assuming parent div is same as child minus 3 letter ext, set primary menu
    menu = menu.substring(0, (menu.length-3));

    if (ddSwitch==0){
        /* if menus were initially off */
        ddDir(menu);
        ddShow(menu);
        ddSwitch=1;
    } else {
        /* if the menu was open, turn that menu off */
        if (d.getElementById(menu).style.display=="block"){
            ddHide(menu);
            ddSwitch=0;
        /* otherwise confirm/turn other menus off before displaying primary menu */
        } else {
            ddHideAll();
            ddDir(menu);
            ddShow(menu);
            ddSwitch=1;
        }
    }
}
/* - parameters set for glide menus - */
GlideParams = {
	START_SPEED : 400, // px per second
	HIDE_DELAY_MS : 250,
	SHOW_DELAY_MS : 2000, // pause before showing submenu
	ACCELERATION_OUT :  .009, // px/second/millisecond
	ACCELERATION_BACK : .0009, // px/second/millisecond
	FRAME_PAUSE : 1,
	CLICK_HIDE : false,
	CLICK_SHOW : false,
	IMG_OVER_EXT : "MO"
};

if (!(/Safari/.test(navigator.userAgent)) && !(/Linux/.test(navigator.userAgent))){
	document.write("<style type='text/css'>.menuFrame{display:block;}</style>");
}
/*****************************************************
 * GlideMenus by Garrett Smith
 * 02-22-2004 v2.1
 *****************************************************/

GM_DOMAIN = "*";
GM_CREATOR = "DHTMLKITCHEN";
GM_LICENSEE = "Cisco";

ua = new function() {
	var u = navigator.userAgent, d = document;
	this.ie = typeof d.all != "undefined";
	this.ns4 = typeof d.layers != "undefined";
	this.dom = typeof d.getElementById != "undefined";
	this.safari = /Safari/.test(u);
	this.moz = /Gecko/.test(u) && !this.safari;
	this.mie = this.ie && /Mac/.test(u);
	this.win9x = /Win9/.test(u) || /Windows 9/.test(u);
	this.o7 = /Opera 7/.test(u);
	this.supported = (typeof d.write != "undefined") && (this.ie || this.ns4 || this.dom);
	this.px = this.dom && d.compatMode != "BackCompat" || this.mie ? "px" : 0;
	this.dblThread = this.ie && this.win9x || this.safari;
};
//------------------------------------------------------------------------

if(GlideParams.CLICK_HIDE)
	document.onmousedown = function(e) {
		var am = GlideMenus.activeMenu;
		if(!am || contains(am.actuator, getTarget(e)) || contains(am.el, getTarget(e))) return;
		am.hideTree();
		GlideMenus.activeMenu = null;
	};

function showMenu(e, id, dir, adjX, adjY) {
	var menu = GlideMenu.getInstance(e, id, dir);

	if(!menu.actuator)
		menu.actuator = menu.getActuator(e);
	menu.over = true;

	if(menu.parentMenu == null) {
		var am = GlideMenus.activeMenu;
		if(am && am != menu && !am.closing()) {
			clearTimeout(am.animTimer);
			clearTimeout(am.animTimer2);
			am.hideTree();
 		}
	}

	// if this menu is scheduled to close, cancel it.
	window.clearTimeout(menu.hideTimer);

	if (menu.closing())
		menu.glideBackEnd();
	else
		clearTimeout(menu.showTimer);

	if(GlideMenus.activeMenu && GlideMenus.activeMenu == menu) return;


	GlideMenus.activeMenu = menu;
	clearTimeout(menu.showTimer);

	GlideMenu.positionFrame(menu, e, adjX, adjY);
	menu.glideOutStart(true);
};

function showSubMenu(e, parentMenuId, id, dir, adjX, adjY) {

	var menu = GlideMenu.getInstance(e, id, dir);
	if(!menu.actuator)
		menu.actuator = menu.getActuator(e);
	clearTimeout(menu.hideTimer);
	menu.over = true;
	menu.parentMenu = GlideMenus[parentMenuId];

	if(ua.ns4) adjX -= e.layerX;

	GlideMenu.positionFrame(menu, e, adjX + menu.parentMenu.w(), adjY);

	var activeMenu = menu.parentMenu.activeMenu;
	if(activeMenu != null && activeMenu != menu) {
		if(!activeMenu.opening || !activeMenu.fullyOpen()) {
			menu.showTimer = setTimeout(menu.GlideOutStartStr, GlideParams.SHOW_DELAY_MS);
		}
		else
			menu.parentMenu.activeMenu.menuInCue = menu;
		return;
	}


	clearTimeout(menu.parentMenu.hideTimer);
	if (menu.closing())
		menu.glideBackEnd();
	else if(menu.fullyClosed())
		menu.showTimer = setTimeout(menu.GlideOutStartStr, GlideParams.SHOW_DELAY_MS);
}

/** Called from onmouseout of submenu's actuator.
 * The only other function that hides a sub is
 * GlideMenu.onmouseover
 */
function hideSubMenu(id) {

	var menu = GlideMenus[id];

	clearTimeout(menu.showTimer);

	if(menu.parentMenu != null
		&& menu.parentMenu.activeMenu != null
		&& menu.parentMenu.activeMenu.menuInCue != null
		&& menu.parentMenu.activeMenu.menuInCue != menu) {
		menu.parentMenu.activeMenu.menuInCue.hide();
	}

	window.clearTimeout(menu.hideTimer);

	menu.over = false;


	// if over parentMenu,
	// this menu will be hidden by GlideMenus.onmouseout
 	if(menu.parentMenu && (!menu.parentMenu.over || GlideParams.CLICK_HIDE))
 		return;

	menu.hideTimer = window.setTimeout(menu.hideStr, GlideParams.HIDE_DELAY_MS);
}

function headerMouseover(imgName_or_element) {
	if(GlideMenus.activeMenu)
		GlideMenus.activeMenu.hideTree();

	if(typeof imgName_or_element == "string") {
		var img = document.images[imgName_or_element];
		img.lowSrc = img.src;
		img.src = img.src.replace(Exps.EXT, GlideParams.IMG_OVER_EXT+"$1");
	}
	else {
		var el = imgName_or_element;
		el.className += " hover";
	}
}

function headerMouseout(imgName_or_element) {
	if(typeof imgName_or_element == "string") {
		var img = document.images[imgName_or_element];
		img.src = img.lowSrc;
	}
	else {
		var el = imgName_or_element;
		removeClass(el, "hover");
	}
}


function actuatorMouseover(event, menuId, dir, adjX, adjY) {
	if(adjX == null) adjX = 0;
	if(adjY == null) adjY = 0;

	var tgt = event.srcElement;
	if (tgt == null){
		tgt=event.target;
	}

	if(tgt.className.search(/.*nav.*/)>-1 || GlideMenus[menuId]!=null){
		if(GlideParams.CLICK_SHOW) {
			var menu = GlideMenu.getInstance(event, menuId, dir);
			menu.getActuator(event);
			menu.hiliteHdr();
			if(GlideMenus.activeMenu )
				if(GlideMenus.activeMenu.id != menuId) {
					hideMenu(GlideMenus.activeMenu.id);
					showMenu(event, menuId, dir, adjX, adjY);
				}
				else
					GlideMenus.activeMenu.glideOutStart();
		}
		else
			showMenu(event, menuId, dir, adjX, adjY);
	}


}

function actuatorMouseout(event, menuId) {

	if(GlideParams.CLICK_SHOW) {
		var menu = GlideMenu.getInstance(event, menuId, "");
		menu.getActuator(event);
		menu.over = false;
		if(menu.fullyClosed())
			menu.unhiliteHdr();
	}
	else
		hideMenu(menuId);
}


/** Schedule menu to close after <Params.HIDE_DELAY_MS> ms, which
 *  gives the user time to cancel the action if they accidentally moused out.
 */
function hideMenu(id) {

	var menu = GlideMenus[id];

	if(menu == null || menu.frame == null) return;
	if(!menu.opening && !menu.fullyOpen()) return;
	window.clearTimeout(menu.hideTimer);
	window.clearTimeout(menu.showTimer);

	if(!menu.opening) {
		window.clearInterval(menu.animTimer);
		window.clearInterval(menu.animTimer2);
	}


	// XXX :confused:
	if(menu.activeMenu)
		 menu.activeMenu.hideTimer = window.setTimeout(menu.activeMenu.hideStr, 1100);

	menu.over = false;
	if(menu.activeMenu) return;

	if(GlideParams.CLICK_HIDE) return;

	menu.hideTimer = window.setTimeout(menu.hideStr, GlideParams.HIDE_DELAY_MS);

	clearTimeout(menu.showTimer);
}



GlideMenu = function(e, id, dir) {

	if(!ua.supported) return;

	var d = window.document;

	this.actuator = (e == null) ? null : this.getActuator(e);

	this.id = id;
	this.dir = dir;
	var fID = id + "Frame";

	this.frame = ua.dom ? d.getElementById(fID) : ua.ie ? d.all[fID] : d.layers[fID];
	if(ua.ns4 && !this.frame && d.parentLayer)
		this.frame = d.parentLayer.d.layers[fID];

	if(ua.ns4)
		this.frame.style = this.frame;

	this.el = ua.dom ? d.getElementById(id) : ua.ns4 ? this.frame.layers[id] : d.all[id];
	this.css = ua.ns4 ? this.el : this.el.style;

	if(!ua.ns4 && !ua.mie) {
		if(!ua.o7) //XXX why doesn't o7 like width: auto?
			this.css.height = this.css.width = "auto";
		this.frame.style.width = this.el.offsetWidth + "px";
	}

	// Position of menu when not shown.
	if(this.dir.indexOf("e") >= 0)
		this.startX = -this.w();
	else if(this.dir.indexOf("w") >= 0)
		this.startX = this.w();

	if(this.dir.indexOf("n") >= 0)
		this.startY = this.h();
	else if(this.dir.indexOf("s") >= 0)
		this.startY = -this.h();
	// Position of menu when fully open is always {0,0}.
	var cId = id;
	/**
	 * for some reason this is not getting called for ns4
	 */
	if(ua.ns4) {
		this.frame.captureEvents(Event.MOUSEMOVE);
		this.frame.onmousemove = function(e) {
			GlideMenu.onmouseover(cId);
			var sub;
			if((sub = GlideMenus[cId].activeMenu) == null) return;

			if(e.y > sub.actuator.y + 14 || e.y < sub.actuator.y-1
			  || e.pageX < this.x || e.pageX > this.x + this.clip.width) {

				sub.over = false;
				sub.hideTimer = setTimeout(sub.hideStr, GlideParams.HIDE_DELAY_MS);
			}
		};
	}
	else {
		this.el.onmouseover = function() { GlideMenu.onmouseover(e, cId); };
		this.el.onmouseout = function(e) { GlideMenu.onmouseout(e, cId); };
	}

	var ref = "GlideMenus."+this.id;
	this.GlideOutStartStr = ref+".glideOutStart(true)";
	this.GlideOutStr = ref+".glideOut()";
	this.GlideBackStr = ref+".glideBack()";
	this.hideStr = ref+".hide()";


	//set initial state
	this.moveTo(this.startX, this.startY);
	this.initAnimProps();

	GlideMenus[id] = this;
};

GlideMenus = { activeMenu : null };

GlideMenu.getInstance = function(e, id, dir) {
	if(GlideMenus[id] == null)
		GlideMenus[id] = new GlideMenu(e, id, dir);

	return GlideMenus[id];
};

GlideMenu.onmouseover = function(e, cId) {

		var menu = GlideMenus[cId];

		var toEl = e ? (window.event) ? window.event.toElement : e.relatedTarget : null;
 			menu.over = true;

		if(GlideParams.CLICK_HIDE) {
			if(menu.activeMenu && !menu.activeMenu.over) {

				if(contains(menu.el, toEl)) // over an item, hide the sub!
					menu.activeMenu.hide();
				else // outside the menu, set a timer on the sub.
					if(!menu.activeMenu.hideTimer)
						hideSubMenu(menu.activeMenu.id);
			}
			return;
		}

		// menu may be closing.
		// clear timers and Glide it out.
		clearTimeout(menu.hideTimer);

		if(!menu.opening && !menu.fullyOpen()) {
			clearInterval(menu.animTimer);
			clearInterval(menu.animTimer2);
			menu.glideOutStart(false);
		}

		if(menu.parentMenu){
			menu.parentMenu.over = false;
			clearTimeout(menu.parentMenu.hideTimer);
		}
	};

GlideMenu.onmouseout = function(e, cId) {
		var toEl = (window.event) ? window.event.toElement : e.relatedTarget;
		if(contains(GlideMenus[cId].el, toEl)) return;
		hideMenu(cId);
	};

GlideMenu.positionFrame = function(menu, e, adjX, adjY) {
	if(ua.ns4) return;
	if(typeof adjX == "number") {
		// mac IE does not calculate offsetWidth properly.
		if(ua.mie && menu.actuator) {
			var actuatorPaddingL = parseInt(menu.actuator.currentStyle.paddingLeft);
			if(!isNaN(actuatorPaddingL))
				adjX -= actuatorPaddingL;
		}

		var left = getPageOffset(menu.actuator, "offsetLeft");
		menu.frame.style.left = Math.round(left + adjX) + ua.px;
	}
	if(typeof adjY == "number"){
		var top = (ua.ns4 ? e.y - menu.actuator.y : getPageOffset(menu.actuator, "offsetTop"));
		var elHeight = menu.actuator.offsetHeight;
		menu.frame.style.top = Math.round(top  + adjY + elHeight) + ua.px;
	}
};


GlideMenu.prototype = {

	el : null,
	css : null,
	frame : null,

	actuator : null,
	imgSrc : null,
	hiSrc : null,

	parentMenu : null,
	activeMenu : null,
	showTimer : 0,
	hideTimer : 0,
	animTimer : 0,
	animTimer2 : 0,

	startX : 0,
	endX : 0,
	startY : 0,
	endY : 0,

	dir : "s",

	GlideOutStartStr : "",
	GlideOutStr : "",
	GlideBackStr : "",
	hideStr : "",

	opening : false,

	// is the cursor over something that keeps the menu open?
	over : false,
	GlideDist : 0,
	rx : 0,
	ry : 0,
	del: 0,


	glideOutStart : function(bActivate) {
		if(bActivate)
			this.onactivate();
		if(this.fullyOpen()) return;
		this.hiliteHdr();

		if(this.opening)
 			clearTimeout(this.hideTimer);

		this.opening = true;

		if(this.parentMenu)
			this.parentMenu.activeMenu = this;

 		this.GlideStartOffset = this.GlideDist - Math.sqrt(this.x*this.x + this.y*this.y);

		this.frame.style.visibility = "visible";

		if(this.parentMenu == null)
			GlideMenus.activeMenu = this;

		// menu may be closing at this point.
		// to avoid concurrent competing threads, clear all close timers.
		window.clearInterval(this.animTimer);
		window.clearInterval(this.animTimer2);

		this.startTime = new Date().getTime();

		this.animTimer = window.setInterval(this.GlideOutStr, this.del);
		if(ua.dblThread)
			this.animTimer2 = window.setInterval(this.GlideOutStr, this.del);
	},

	glideBackStart : function() {

		this.ondeactivate();
		this.unhiliteHdr();
		if(this.fullyClosed())
			return;


		this.opening = false;

		if(this.parentMenu && this.parentMenu.activeMenu == this)
			this.parentMenu.activeMenu = null;
 		this.GlideBackOffset = -(this.rx*this.x + this.ry*this.y);

		// menu may be opening at this point.
		window.clearInterval(this.animTimer);
		window.clearInterval(this.animTimer2);

		this.startTime = new Date().getTime();
		this.animTimer = window.setInterval(this.GlideBackStr, this.del );
		if(ua.dblThread)
			this.animTimer2 = window.setInterval(this.GlideBackStr, this.del);
	},

	glideOut : function() {
		var t = new Date().getTime() - this.startTime;
		var d = Math.ceil(GlideParams.START_SPEED/1000 * t + .5 * GlideParams.ACCELERATION_OUT * t*t)
			    + this.GlideStartOffset;
		if(d >= this.GlideDist) {
			this.moveTo(0, 0);
 			this.glideOutEnd( );
		}
		else {
 			this.moveTo(this.startX + d * this.rx, this.startY + d * this.ry);
		}
	},

	glideBack : function() {

		var t = new Date().getTime() - this.startTime;
		var d = Math.ceil(GlideParams.START_SPEED/1000 * t + .5 * GlideParams.ACCELERATION_BACK * t*t)
			   + this.GlideBackOffset;
		if(d >= this.GlideDist) {
			this.moveTo(this.startX, this.startY);
 			this.glideBackEnd( );
		}
		else {
			this.moveTo(-d * this.rx, -d * this.ry);
		}
	},

	glideOutEnd : function() {

		this.animTimer = window.clearTimeout(this.animTimer);
		this.animTimer2 = window.clearTimeout(this.animTimer2);

		if(!this.parentMenu)
			GlideMenus.activeMenu = this;

		else if(ua.ns4) // over (for ns4, but not sure how we got here).
			;//this.glideOutStart(false);
	},

	glideBackEnd : function() {
		this.animTimer = window.clearTimeout(this.animTimer);
		this.animTimer2 = window.clearTimeout(this.animTimer2);

		if(this.menuInCue && this.menuInCue.over) {
			if(this.parentMenu)
				(this.parentMenu.activeMenu = this.menuInCue).glideOutStart();

			this.menuInCue = null;
		}
		else if(!this.parentMenu && !this.menuInCue && GlideMenus.activeMenu == this && !GlideParams.CLICK_HIDE)
			GlideMenus.activeMenu = null;

	//	this.frame.style.visibility = "hidden";

		if(this.parentMenu) {
			if(!this.parentMenu.over && this.fullyClosed() && !GlideParams.CLICK_HIDE)
				this.parentMenu.glideBackStart();
			else if(this.over) // over actuator
				this.glideOutStart(false);
			if(!GlideParams.CLICK_HIDE)
				this.parentMenu = null;
		}
		if(!this.over)
			this.frame.style.visibility = "hidden";

	},

	hiliteHdr : function() {
		if(!this.actuator) return;
		var src;
		if((src = this.actuator.src) != null) {
			if(!this.imgSrc) {
				this.imgSrc = src;
				this.hiSrc = new Image().src = src.replace(Exps.EXT, GlideParams.IMG_OVER_EXT+"$1");
			}
			this.actuator.src = this.hiSrc;
		}
 		if(!ua.ns4){
			this.actuator.className = (this.actuator.className + " hover").trim();
			this.frame.style.zIndex = (this.parentMenu) ? parseInt(this.parentMenu.frame.style.zIndex) + 1 : 100;
		}
	},

	unhiliteHdr : function() {
		if(!this.actuator) return;

		if(this.actuator.src) {
			this.actuator.src = this.imgSrc;
		}
		if(!ua.ns4){
			removeClass(this.actuator, "hover");
			if(!this.parentMenu)
				this.frame.style.zIndex = "";
		}
	},

	hide : function() {

		// cursor is not over something that should keep menu open.
		if(this.over) return;

		this.activeMenu = null;
		window.clearTimeout(this.hideTimer);

		// if this menu is open, close it.;
		if (this.opening || this.fullyOpen()) {
			this.unhiliteHdr();
			this.glideBackStart();
		}
		else if(!this.closing())
			this.parentMenu = null;
	},

	hideTree : function() {
		var am = this;
		for(; am.activeMenu != null; am = am.activeMenu);
		for(var p = am; (p = p.parentMenu) != null; p.hide());
		am.hide();
	},

	moveTo : (ua.ie ?
		function(x,y) {this.x=this.css.posLeft=x;this.y=this.css.posTop=y;}	:
		function(x, y) {
			this.css.left = (this.x = x) + ua.px;
			this.css.top = (this.y = y) + ua.px;
		}),

	closing : function() {
		return this.animTimer && !this.opening;
	},

	fullyOpen : function() {
		return this.x == 0 && this.y == 0;
	},
	fullyClosed : function() {
		return this.x == this.startX && this.y == this.startY;
	},

	overSubmenu : function() {
		for(var menu = this; menu != null;menu = menu.activeMenu)
			if(menu.over) return true;
		return false;
	},

	initAnimProps : function() {

		// calculate the hypoteneuse.
		this.GlideDist = Math.ceil(Math.sqrt(Math.pow(this.startX, 2) + Math.pow(this.startY, 2)));
		// ratio of x and y to hypoteneuse
		this.rx = -this.startX/this.GlideDist;
		this.ry = -this.startY/this.GlideDist;

		this.del = GlideParams.FRAME_PAUSE;

		// time delay is further reduced.
		// a delay of less than 50ms takes longer than whatever it is in IE windows 9x.
		// other browsers show little difference with very low delays.
		if(ua.win9x && ua.ie && this.del < 54)
			this.del = Math.floor(Math.pow(this.del, 1 - (.54 - this.del/100)));
	},

	/** methods for w and h allow menus to reposition based on updated
	 * layout values (perhaps due to font-size change).
	 */
	w : function() { return ua.ns4 ? this.frame.clip.width : this.el.offsetWidth; },
	h : function() { return ua.ns4 ? this.frame.clip.height : this.el.offsetHeight; },
	getActuator : function(e) {
		var el = getTarget(e);
		return el ? (el.nodeType == 3) ? el.parentNode : el : null;
	},

	toString : function() { return this.id; },

	onactivate : function(){},
	ondeactivate : function(){}
};

if(ua.supported)
	document.writeln("<style type='text/css'>.menuFrame{visibility:hidden;}<"+"/style>");

function contains(a, b) {
	if(b == null) return false;
	while(a != b && ((b = b.parentNode) != null || ua.ns4 && (b = b.parentLayer) != null));
	return a == b;
}
function getPageOffset(el, off){
	var total = 0;
	if(typeof el[off] == "number")
		for(var parent = el; parent.offsetParent != null; parent = parent.offsetParent)
			total += parent[off];
	return total;
}
function getTarget(e){return e&&e.target?e.target:(window.event)?event.srcElement:null;}
function removeClass(el,klass){el.className=el.className.replace(getTokenizedExp(klass,"g")," ").normalize();}
String.prototype.normalize=function(){return this.trim().replace(Exps.NORMALIZE," ");};
String.prototype.trim=function(){return this.replace(Exps.TRIM,"");};
Exps={NORMALIZE:/\s\s+/g,TRIM:/^\s+|\s+$/g,EXT:/(\.(.[^\.]+)$)/};
function getTokenizedExp(t,f){var x=Exps[t];if(!x)x=Exps[t]=new RegExp("(^|\\s)"+t+"($|\\s)",f);return x;}
function getCookie(name) {
	var match = (new RegExp(name+'\s?=\s?([^;]*);?', 'g')).exec(document.cookie)||[];
	return match.length>1?unescape(match[1]):null;
}

/* - swfobject code -*/
/**
 * SWFObject v1.4.4: Flash Player detection and embed - http://blog.deconcept.com/swfobject/
 *
 * SWFObject is (c) 2006 Geoff Stearns and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 *
 * **SWFObject is the SWF embed script formerly known as FlashObject. The name was changed for
 *   legal reasons.
 */
if(typeof deconcept=="undefined"){var deconcept=new Object();}
if(typeof deconcept.util=="undefined"){deconcept.util=new Object();}
if(typeof deconcept.SWFObjectUtil=="undefined"){deconcept.SWFObjectUtil=new Object();}
deconcept.SWFObject=function(_1,id,w,h,_5,c,_7,_8,_9,_a,_b){if(!document.getElementById){return;}
this.DETECT_KEY=_b?_b:"detectflash";
this.skipDetect=deconcept.util.getRequestParameter(this.DETECT_KEY);
this.params=new Object();
this.variables=new Object();
this.attributes=new Array();
if(_1){this.setAttribute("swf",_1);}
if(id){this.setAttribute("id",id);}
if(w){this.setAttribute("width",w);}
if(h){this.setAttribute("height",h);}
if(_5){this.setAttribute("version",new deconcept.PlayerVersion(_5.toString().split(".")));}
this.installedVer=deconcept.SWFObjectUtil.getPlayerVersion();
if(c){this.addParam("bgcolor",c);}
var q=_8?_8:"high";
this.addParam("quality",q);
this.setAttribute("useExpressInstall",_7);
this.setAttribute("doExpressInstall",false);
var _d=(_9)?_9:window.location;
this.setAttribute("xiRedirectUrl",_d);
this.setAttribute("redirectUrl","");
if(_a){this.setAttribute("redirectUrl",_a);}};
deconcept.SWFObject.prototype={setAttribute:function(_e,_f){
this.attributes[_e]=_f;
},getAttribute:function(_10){
return this.attributes[_10];
},addParam:function(_11,_12){
this.params[_11]=_12;
},getParams:function(){
return this.params;
},addVariable:function(_13,_14){
this.variables[_13]=_14;
},getVariable:function(_15){
return this.variables[_15];
},getVariables:function(){
return this.variables;
},getVariablePairs:function(){
var _16=new Array();
var key;
var _18=this.getVariables();
for(key in _18){_16.push(key+"="+_18[key]);}
return _16;},getSWFHTML:function(){var _19="";
if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){
if(this.getAttribute("doExpressInstall")){
this.addVariable("MMplayerType","PlugIn");}
_19="<embed type=\"application/x-shockwave-flash\" src=\""+this.getAttribute("swf")+"\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\"";
_19+=" id=\""+this.getAttribute("id")+"\" name=\""+this.getAttribute("id")+"\" ";
var _1a=this.getParams();
for(var key in _1a){_19+=[key]+"=\""+_1a[key]+"\" ";}
var _1c=this.getVariablePairs().join("&");
if(_1c.length>0){_19+="flashvars=\""+_1c+"\"";}_19+="/>";
}else{if(this.getAttribute("doExpressInstall")){this.addVariable("MMplayerType","ActiveX");}
_19="<object id=\""+this.getAttribute("id")+"\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" width=\""+this.getAttribute("width")+"\" height=\""+this.getAttribute("height")+"\">";
_19+="<param name=\"movie\" value=\""+this.getAttribute("swf")+"\" />";
var _1d=this.getParams();
for(var key in _1d){_19+="<param name=\""+key+"\" value=\""+_1d[key]+"\" />";}
var _1f=this.getVariablePairs().join("&");
if(_1f.length>0){_19+="<param name=\"flashvars\" value=\""+_1f+"\" />";}_19+="</object>";}
return _19;
},write:function(_20){
if(this.getAttribute("useExpressInstall")){
var _21=new deconcept.PlayerVersion([6,0,65]);
if(this.installedVer.versionIsValid(_21)&&!this.installedVer.versionIsValid(this.getAttribute("version"))){
this.setAttribute("doExpressInstall",true);
this.addVariable("MMredirectURL",escape(this.getAttribute("xiRedirectUrl")));
document.title=document.title.slice(0,47)+" - Flash Player Installation";
this.addVariable("MMdoctitle",document.title);}}
if(this.skipDetect||this.getAttribute("doExpressInstall")||this.installedVer.versionIsValid(this.getAttribute("version"))){
var n=(typeof _20=="string")?document.getElementById(_20):_20;
n.innerHTML=this.getSWFHTML();return true;
}else{if(this.getAttribute("redirectUrl")!=""){document.location.replace(this.getAttribute("redirectUrl"));}}
return false;}};
deconcept.SWFObjectUtil.getPlayerVersion=function(){
var _23=new deconcept.PlayerVersion([0,0,0]);
if(navigator.plugins&&navigator.mimeTypes.length){
var x=navigator.plugins["Shockwave Flash"];
if(x&&x.description){_23=new deconcept.PlayerVersion(x.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s+r|\s+b[0-9]+)/,".").split("."));}
}else{try{var axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7");}
catch(e){try{var axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6");
_23=new deconcept.PlayerVersion([6,0,21]);axo.AllowScriptAccess="always";}
catch(e){if(_23.major==6){return _23;}}try{axo=new ActiveXObject("ShockwaveFlash.ShockwaveFlash");}
catch(e){}}if(axo!=null){_23=new deconcept.PlayerVersion(axo.GetVariable("$version").split(" ")[1].split(","));}}
return _23;};
deconcept.PlayerVersion=function(_27){
this.major=_27[0]!=null?parseInt(_27[0]):0;
this.minor=_27[1]!=null?parseInt(_27[1]):0;
this.rev=_27[2]!=null?parseInt(_27[2]):0;
};
deconcept.PlayerVersion.prototype.versionIsValid=function(fv){
if(this.major<fv.major){return false;}
if(this.major>fv.major){return true;}
if(this.minor<fv.minor){return false;}
if(this.minor>fv.minor){return true;}
if(this.rev<fv.rev){
return false;
}return true;};
deconcept.util={getRequestParameter:function(_29){
var q=document.location.search||document.location.hash;
if(q){var _2b=q.substring(1).split("&");
for(var i=0;i<_2b.length;i++){
if(_2b[i].substring(0,_2b[i].indexOf("="))==_29){
return _2b[i].substring((_2b[i].indexOf("=")+1));}}}
return "";}};
deconcept.SWFObjectUtil.cleanupSWFs=function(){if(window.opera||!document.all){return;}
var _2d=document.getElementsByTagName("OBJECT");
for(var i=0;i<_2d.length;i++){_2d[i].style.display="none";for(var x in _2d[i]){
if(typeof _2d[i][x]=="function"){_2d[i][x]=function(){};}}}};
deconcept.SWFObjectUtil.prepUnload=function(){__flash_unloadHandler=function(){};
__flash_savedUnloadHandler=function(){};
if(typeof window.onunload=="function"){
var _30=window.onunload;
window.onunload=function(){
deconcept.SWFObjectUtil.cleanupSWFs();_30();};
}else{window.onunload=deconcept.SWFObjectUtil.cleanupSWFs;}};
if(typeof window.onbeforeunload=="function"){
var oldBeforeUnload=window.onbeforeunload;
window.onbeforeunload=function(){
deconcept.SWFObjectUtil.prepUnload();
oldBeforeUnload();};
}else{window.onbeforeunload=deconcept.SWFObjectUtil.prepUnload;}
if(Array.prototype.push==null){
Array.prototype.push=function(_31){
this[this.length]=_31;
return this.length;};}
var getQueryParamValue=deconcept.util.getRequestParameter;
var FlashObject=deconcept.SWFObject;
var SWFObject=deconcept.SWFObject;
