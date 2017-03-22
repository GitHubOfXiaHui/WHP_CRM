/**********************************************************************************************************************
*Return value
**********************************************************************************************************************/
var KIOSK_SUCCESS		= 1001;
var KIOSK_FAIL		= 1002;
var KIOSK_ERROR_INVALID_HANDLE		= 1101;
var KIOSK_ERROR_INVALID_PARAMETER		= 1102;
var KIOSK_ERROR_LOADLIBRARY		= 1103;
var KIOSK_ERROR_INVALID_PATH		= 1103;
var KIOSK_ERROR_NOT_BITMAP		= 1104;
var KIOSK_ERROR_NOT_MONO_BITMAP		= 1105;
var KIOSK_ERROR_BEYOND_AREA		= 1106;

/**********************************************************************************************************************
*Port type
**********************************************************************************************************************/
var KIOSK_COM		=  0x00;
var KIOSK_LPT		= (KIOSK_COM + 0x01);
var KIOSK_USB		= (KIOSK_COM + 0x02);
var KIOSK_DRV		= (KIOSK_COM + 0x03);
var KIOSK_NIBBLEPAR	= (KIOSK_COM + 0x04);
var KIOSK_NET		= (KIOSK_COM + 0x05);
var KIOSK_USBCLASSS	= (KIOSK_COM + 0x06);

var KIOSK_PAPER_SERIAL		= 0x00;
var KIOSK_PAPER_MARK		= 0x01;

/**********************************************************************************************************************
*Stop bits
**********************************************************************************************************************/
var	KIOSK_COM_ONESTOPBIT	=0x00;
var	KIOSK_COM_TWOSTOPBITS	=0x01;

/**********************************************************************************************************************
*Parity
**********************************************************************************************************************/
var	KIOSK_COM_NOPARITY		=0x00;        
var	KIOSK_COM_ODDPARITY		=0x01;
var	KIOSK_COM_EVENPARITY	=0x02;
var	KIOSK_COM_MARKPARITY	=0x03;
var	KIOSK_COM_SPACEPARITY	=0x04;

/**********************************************************************************************************************
*Flow control 
**********************************************************************************************************************/
var	KIOSK_COM_DTR_DSR		=0x00;
var	KIOSK_COM_RTS_CTS		=0x01;
var	KIOSK_COM_XON_XOFF		=0x02;
var	KIOSK_COM_NO_HANDSHAKE	=0x03;

/**********************************************************************************************************************
*Mode of printing
**********************************************************************************************************************/
var KIOSK_PRINT_MODE_STANDARD		= 0x00;
var KIOSK_PRINT_MODE_PAGE		= 0x01;

/**********************************************************************************************************************
*Font type
**********************************************************************************************************************/
var KIOSK_FONT_TYPE_STANDARD		= 0x00;
var KIOSK_FONT_TYPE_COMPRESSED		= 0x01;
var KIOSK_FONT_TYPE_UDC		= 0x02;
var KIOSK_FONT_TYPE_CHINESE		= 0x03;

/**********************************************************************************************************************
*Print style
**********************************************************************************************************************/
var KIOSK_FONT_STYLE_NORMAL		= 0x00;
var KIOSK_FONT_STYLE_BOLD		= 0x08;
var KIOSK_FONT_STYLE_THIN_UNDERLINE		= 0x80;
var KIOSK_FONT_STYLE_THICK_UNDERLINE		= 0x100;
var KIOSK_FONT_STYLE_UPSIDEDOWN		= 0x200;
var KIOSK_FONT_STYLE_REVERSE		= 0x400;
var KIOSK_FONT_STYLE_CLOCKWISE_90		= 0x1000;

/**********************************************************************************************************************
*Bitmap mode
**********************************************************************************************************************/
var KIOSK_BITMAP_MODE_8SINGLE_DENSITY		= 0x00;
var KIOSK_BITMAP_MODE_8DOUBLE_DENSITY		= 0x01;
var KIOSK_BITMAP_MODE_24SINGLE_DENSITY		= 0x20;
var KIOSK_BITMAP_MODE_24DOUBLE_DENSITY		= 0x21;

/**********************************************************************************************************************
*Bitmap print mode
**********************************************************************************************************************/
var KIOSK_BITMAP_PRINT_NORMAL		= 0x00;
var KIOSK_BITMAP_PRINT_DOUBLE_WIDTH		= 0x01;
var KIOSK_BITMAP_PRINT_DOUBLE_HEIGHT		= 0x02;
var KIOSK_BITMAP_PRINT_QUADRUPLE		= 0x03;

/**********************************************************************************************************************
*Barcode type
**********************************************************************************************************************/
var KIOSK_BARCODE_TYPE_UPC_A		= 0x41;
var KIOSK_BARCODE_TYPE_UPC_E		= 0x42;
var KIOSK_BARCODE_TYPE_JAN13		= 0x43;
var KIOSK_BARCODE_TYPE_JAN8		= 0x44;
var KIOSK_BARCODE_TYPE_CODE39		= 0x45;
var KIOSK_BARCODE_TYPE_ITF		= 0x46;
var KIOSK_BARCODE_TYPE_CODEBAR		= 0x47;
var KIOSK_BARCODE_TYPE_CODE93		= 0x48;
var KIOSK_BARCODE_TYPE_CODE128		= 0x49;

/**********************************************************************************************************************
*Hri font position
**********************************************************************************************************************/
var KIOSK_HRI_POSITION_NONE		= 0x00;
var KIOSK_HRI_POSITION_ABOVE		= 0x01;
var KIOSK_HRI_POSITION_BELOW		= 0x02;
var KIOSK_HRI_POSITION_BOTH		= 0x03;

/**********************************************************************************************************************
*Print direction
**********************************************************************************************************************/
var KIOSK_AREA_LEFT_TO_RIGHT		= 0x00;
var KIOSK_AREA_BOTTOM_TO_TOP		= 0x01;
var KIOSK_AREA_RIGHT_TO_LEFT		= 0x02;
var KIOSK_AREA_TOP_TO_BOTTOM		= 0x03;

var KIOSK_PRESENTER_Retraction_on		= 0x00;
var KIOSK_PRESENTER_Paper_Forward		= 0x01;
var KIOSK_PRESENTER_Paper_Hold		= 0x02;

var KIOSK_BUNDLER_Retract		= 0x00;
var KIOSK_BUNDLER_Present		= 0x01;

/**********************************************************************************************************************
*Define operation process
**********************************************************************************************************************/
var Macro_Process_Init			=	0x00;							//Init
var Macro_Process_OpenPort		=	(Macro_Process_Init + 0x01);		//Open port
var Macro_Process_Print			=	(Macro_Process_Init + 0x02);		//Print process
var Macro_Process_StatusMonitor	=	(Macro_Process_Init + 0x03);	//Status monitor
var Macro_Process_ClosePort		=	(Macro_Process_Init + 0x04);		//Close port

var Macro_PageWidth_56mm		=	0x00;							//56mm
var Macro_PageWidth_80mm		=	(Macro_PageWidth_56mm + 0x01);	//80mm
var Macro_PageWidth_210mm		=	(Macro_PageWidth_56mm + 0x02);	//210mm

var Macro_Resolution_203DPI		=	203;								//203dpi
var Macro_Resolution_300DPI		=	300;								//300dpi

var Macro_PrintContent_Text		=	0x00;							//Print text
var Macro_PrintContent_Image	=	(Macro_PrintContent_Text + 0x01);//Print image
var Macro_PrintContent_Barcode	=	(Macro_PrintContent_Text + 0x02);//Print barcode

var iPortType = KIOSK_COM;          //Port type,0-COM,1-LPT,2-NibblePar,3-USB API,4-USB Class,5-Driver
var iComNameIndex = "COM1";   //COM name index
var iBaudrateIndex = 9600;    //baudrate index
var iDataBitsIndex = 8;       //DataBits index
var iStopBitsIndex = 1;       //StopBits index
var iParityIndex = 0;    //Parity index
var iFlowControlIndex = 2;    //Flow Control index
var iLptAddr = "0x0378";         //LPT address
var i_NibblePar_Addr = "LPT1";          //NibblePar address
var iPortNum = 1;             //Port number
var iDevNum = 1;              //device number
var iWrTime = 5000;           //write port timeout
var iReTime = 5000;           //read port timeout
var USBPrinterNameList = "";  //class mode USB port device name list
var DriverNameList = "";      //printer driver name list
var USBPrinterName = "";      //class mode USB port device name 
var DriverName = "";          //printer driver name 

//******ico ****************/
var icoRight = "RIGHT.ico";//
var icoErr = "ERR.ico";//
var icoInit = "INIT.ico";//
/***************************/

var m_hPort = -1;             //handle of opened port
var uni_PrintContent= Macro_PrintContent_Text;		//Print content
var uni_PrintMode= KIOSK_PRINT_MODE_STANDARD;	//Print mode
var uni_PageWidth= Macro_PageWidth_80mm;			//Page width
var uni_Resolution	= Macro_Resolution_203DPI;		//Resolution
var uni_OperationProcess=Macro_Process_Init;		//Operation process
var iPortType = KIOSK_COM;
var statusResult = new String();//

var timerunning = false;
var timeID;

var thisPath;   //the path of the KIOSKOCXDemo.html
var bmpPath = thisPath;  //"C:\\WINDOWS\\system32\\";
var nibbleParDllPath = "C:\\WINDOWS\\system32";  //"C:\\WINDOWS\\system32";
var saveFilePath = thisPath;

/******************************
Function:showDivKIOSKOCXDemo()
Parameter:SELECT 
Description:show main page
*******************************/

function showDivKIOSKOCXDemo()
{
	var obj1 = document.getElementById("divPortSetting");
	var obj2 = document.getElementById("divKIOSKOCXDemo");
	obj1.style.display="none";
	obj2.style.display="block";
}

/******************************
Function:showDivPortSetting()
Parameter:SELECT 
Description:show port setting page
*******************************/
function showDivPortSetting()
{
	var obj1 = document.getElementById("divPortSetting");
	var obj2 = document.getElementById("divKIOSKOCXDemo");
	obj1.style.display="block";
	obj2.style.display="none";
}

/******************************
Function:getSelectedText()
Parameter:SELECT 
Description:get innerText
*******************************/
function getSelectedText(obj)
{ 
	for(var i=0;i<obj.length;i++)
	{   
		if(obj[i].selected)
		{   
			return obj[i].innerText;
		}   
	}   
} 

/******************************
Function:getSelectedValue()
Parameter:SELECT 
Description:get value
*******************************/
function getSelectedValue(obj)
{     
	return obj.value;  
} 

/******************************
Function:initForm()
Parameter:NULL
Description:init KIOSKOCXDemo.htm
*******************************/
function initForm()
{
	window.top.resizeTo(700,500);
	
	var path = location.pathname;
	path = path.replace("/","");
	path = path.replace("\KIOSKOCXDemo_JavaScript.htm","");
	path = path.replace("%20"," ");//�ո����
	thisPath = path;
	bmpPath = thisPath;
  //nibbleParDllPath = thisPath;
  saveFilePath = thisPath;
	
	uni_OperationProcess = Macro_Process_Init;
	grayControl();
	
	if(KIOSKOCX!=null)
	{
	/*get version: need modify KIOSKOCX*/
	}
}

/******************************
Function:onSaveDatat()
Parameter:NULL
Description:save data to file
*******************************/
function onSaveDatat()
{ 
}

/******************************
Function:getRadioValue(name) 
Parameter:NULL
Description:get value of radio by name
*******************************/ 
function getRadioValue(name){   
	var radioes = document.getElementsByName(name);    
	for(var i=0;i<radioes.length;i++)   
	{   
		 if(radioes[i].checked){   
		  return radioes[i].value;   
		 }   
	}   
	return false;   
} 

/******************************
Function:initFormPortSetting()
Parameter:NULL
Description:init PortSetting.htm
*******************************/
function initFormPortSetting()
{
	window.top.resizeTo(700,500);
		
	switch(iPortType)
	{
	case KIOSK_COM: //Serial Port
			form.single_portComName.disabled = false;
			form.single_baudrate.disabled = false;
			form.single_dataBits.disabled = false;
			form.single_stopBits.disabled = false;
			form.single_parity.disabled = false;
			form.single_flowControl.disabled = false;
		
			form.single_USBPrnName.disabled = true;
			form.single_lptAddr.disabled = true;
			form.single_drvName.disabled = true;
			
			form.single_portComName.value = iComNameIndex;
			form.single_baudrate.value = iBaudrateIndex;
			form.single_dataBits.value = iDataBitsIndex;
			form.single_stopBits.value = iStopBitsIndex;
			form.single_parity.value = iParityIndex;
			form.single_flowControl.value = iFlowControlIndex;
      break;
    case KIOSK_LPT:  //Parallel Port
	    form.single_portComName.disabled = true;
			form.single_baudrate.disabled = true;
			form.single_dataBits.disabled = true;
			form.single_stopBits.disabled = true;
			form.single_parity.disabled = true;
			form.single_flowControl.disabled = true;
		
			form.single_USBPrnName.disabled = true;
			form.single_lptAddr.disabled = false;
			form.single_drvName.disabled = true;

			LptAddrStr = "0x0378";
			var texts = new Array("0x0278","0x0378");
			setSelectedText("singleId_lptAddr",texts);
			form.single_lptAddr.value = LptAddrStr;
        break;
    case KIOSK_NIBBLEPAR:   //Nibble Mode Parallel Port
      form.single_portComName.disabled = true;
			form.single_baudrate.disabled = true;
			form.single_dataBits.disabled = true;
			form.single_stopBits.disabled = true;
			form.single_parity.disabled = true;
			form.single_flowControl.disabled = true;
		
			form.single_USBPrnName.disabled = true;
			form.single_lptAddr.disabled = false;
			form.single_drvName.disabled = true;
			
			LptAddrStr = "LPT1";
			var texts = new Array("LPT1","LPT2","LPT3","LPT4");
			setSelectedText("singleId_lptAddr",texts);
			form.single_lptAddr.value = LptAddrStr;
        break;
    case KIOSK_USB:   //API Mode USB Port
	    form.single_portComName.disabled = true;
			form.single_baudrate.disabled = true;
			form.single_dataBits.disabled = true;
			form.single_stopBits.disabled = true;
			form.single_parity.disabled = true;
			form.single_flowControl.disabled = true;
		
			form.single_USBPrnName.disabled = true;
			form.single_lptAddr.disabled = true;
			form.single_drvName.disabled = true;
        break;
    case KIOSK_USBCLASSS:  //Class Mode USB Port
	    form.single_portComName.disabled = true;
			form.single_baudrate.disabled = true;
			form.single_dataBits.disabled = true;
			form.single_stopBits.disabled = true;
			form.single_parity.disabled = true;
			form.single_flowControl.disabled = true;
		
			form.single_USBPrnName.disabled = false;
			form.single_lptAddr.disabled = true;
			form.single_drvName.disabled = true;
			
			var isUSBNameExist = false;
			var temp;
			
			if (KIOSKOCX != null) 
			{
				var usbname = KIOSKOCX.KIOSKGetEnumUSBClassPrinter();//penghaiying modify
					
				//Show class mode USB port deice name
				if(usbname != null & usbname.length != 0)
				{
					var texts = usbname.split("@");	
					var obj = form.single_USBPrnName;
					obj.length=texts.length - 1;
					
					for(i=0;i<texts.length;i++)
					{
						if("" == texts[i])
						{							
							break;
						}
						
						if(USBPrinterName == texts[i])
						{	
							isUSBNameExist = true;
						}

						obj[i].innerText = texts[i];	
						obj[i].value = texts[i];					
					} 
					temp = texts[0];
				}
			}			
	
			if(isUSBNameExist == true)
			{
				form.single_USBPrnName.value = USBPrinterName;
			}
			else
			{
				form.single_USBPrnName.value = temp;	
			}
			
        break;
    case KIOSK_DRV:  //Driver
			form.single_portComName.disabled = true;
			form.single_baudrate.disabled = true;
			form.single_dataBits.disabled = true;
			form.single_stopBits.disabled = true;
			form.single_parity.disabled = true;
			form.single_flowControl.disabled = true;
		
			form.single_USBPrnName.disabled = true;
			form.single_lptAddr.disabled = true;
			form.single_drvName.disabled = false;
			
			var isDrvNameExist = false;
			var temp;
			
			if (KIOSKOCX != null) 
			{
				var drvname = KIOSKOCX.KIOSKGetEnumDriverPrinter("BK");//penghaiying modify		

				//Show Driver Name
				if(drvname != null & drvname.length != 0)
				{
					var texts = drvname.split("@");	
					var obj = form.single_drvName;
					obj.length=texts.length - 1;
					
					for(i=0;i<texts.length;i++)
					{
						if("" == texts[i])
						{							
							break;
						}
						
						if(DriverName == texts[i])
						{	
							isDrvNameExist = true;
						}

						obj[i].innerText = texts[i];	
						obj[i].value = texts[i];					
					} 
					temp = texts[0];
				}
			}			
	
			if(isDrvNameExist == true)
			{
				form.single_drvName.value = DriverName;
			}
			else
			{
				form.single_drvName.value = temp;	
			}

			break;
    }
}

/******************************
Function:setSelectedText(id,texts)
Parameter:NULL
Description:
*******************************/
function setSelectedText(id,texts) {
	if(id==null || texts==null || texts.length<0){
		return;
	}
	var obj=document.getElementById(id); 
	obj.length=texts.length;
	for(i=0;i<obj.length;i++){ 
		obj[i].innerText = texts[i];
		obj[i].value = texts[i];//for test   
	} 	
}

/******************************
Function:onOpenPort()
Parameter:NULL
Description:
*******************************/
function onOpenPort()
{		
  if(KIOSKOCX == null)
	{
		return;
	}
	
	grayControl();
		
	if(iPortType == KIOSK_COM)//serial port
	{		
		m_hPort = KIOSKOCX.KIOSKOpenCom(iComNameIndex,iBaudrateIndex,iDataBitsIndex,iStopBitsIndex,iParityIndex,iFlowControlIndex);
		
		if(m_hPort == -1)
		{	
			form.statusResultName.value = "Can't open selected port!";
			
			return;			
		}
		
	}	
	
	if(iPortType == KIOSK_LPT)//parallel port
	{
		m_hPort = KIOSKOCX.KIOSKOpenLptByDrv(Number(iLptAddr),1);//penghaiying needTest

		if(m_hPort == -1)
		{	
			form.statusResultName.value = "Can't open selected port!";
			
			return;
		}
	

	}
	
	if(iPortType == KIOSK_NIBBLEPAR)//nibble mode parallel port
	{
		m_hPort = KIOSKOCX.KIOSKOpenNibblePar(Number(i_NibblePar_Addr.substr(3)),1,nibbleParDllPath);//penghaiying  "C:\\WINDOWS\\system32"
		
		if(m_hPort == -1)
		{
			form.statusResultName.value = "Can't open selected port!";
			
			return;
		}


	}
	
	if(iPortType == KIOSK_USB)//API mode USB port
	{
		m_hPort = KIOSKOCX.KIOSKOpenUsb();
		
		if(m_hPort == -1)
		{
			form.statusResultName.value = "Can't open selected port!";
			
			return;
		}

	}
	
	if(iPortType == KIOSK_USBCLASSS)//class mode USB port
	{
		m_hPort = KIOSKOCX.KIOSKOpenUsbClass(USBPrinterName);
		
		if(m_hPort == -1)
		{
			form.statusResultName.value = "Can't open selected port!";
			
			return;
		}		

	}
	
	if(iPortType == KIOSK_DRV)//driver
	{
		m_hPort = KIOSKOCX.KIOSKOpenDrv(DriverName);
		
		if(m_hPort == -1)
		{	
			form.statusResultName.value = "Can't open selected port!";
			
			return;
		}		

	}

    uni_OperationProcess = Macro_Process_OpenPort;
	grayControl();
	form.statusResultName.value = "Open selected port successfully!";
}

/******************************
Function:onPortSetting()
Parameter:NULL
Description:
*******************************/
function onPortSetting()
{
	showDivPortSetting();
	initFormPortSetting();
}

/******************************
Function:onOK()
Parameter:NULL
Description:
*******************************/
function onOK()
{	
	if(KIOSKOCX == null)
	{
		return;
	}	
	

	if(iPortType == KIOSK_COM) //Serial port
	{			
		var obj = form.single_portComName;
		iComNameIndex = getSelectedText(obj);		
		
		obj=form.single_baudrate;
		iBaudrateIndex = getSelectedValue(obj);

		obj=form.single_dataBits;
		iDataBitsIndex = getSelectedValue(obj);

		obj=form.single_stopBits;
		iStopBitsIndex = getSelectedValue(obj);

		obj=form.single_parity;
		iParityIndex = getSelectedValue(obj);
		
		obj=form.single_flowControl;
		iFlowControlIndex = getSelectedValue(obj);		
	}
	
	if(iPortType == KIOSK_LPT)//parallel port
	{
		iLptAddr = form.single_lptAddr.value;		
	}
	
	if(iPortType == KIOSK_NIBBLEPAR) //nibble mode parallel port
	{
		i_NibblePar_Addr = form.single_lptAddr.value;			
	}
	
	if(iPortType == KIOSK_USBCLASSS)//Class mode USB port
	{
		USBPrinterName = form.single_USBPrnName.value;
	}	
	
	if(iPortType == KIOSK_DRV)//Driver
	{
		DriverName = form.single_drvName.value;
	}	
	
	showDivKIOSKOCXDemo();		
}

/******************************
Function:onCancel()
Parameter:NULL
Description:
*******************************/
function onCancel()
{
	showDivKIOSKOCXDemo();
}

/******************************
Function:onPrintBarcode()
Parameter:NULL
Description:
*******************************/
function onPrintBarcode()
{
    uni_OperationProcess = Macro_Process_Print;
	uni_PrintContent = Macro_PrintContent_Barcode;
    printProc();
}

/******************************
Function:onStatusStart()
Parameter:NULL
Description:
*******************************/
function onStatusStart()
{
    uni_OperationProcess = Macro_Process_StatusMonitor;
    queryStatus();
}

/******************************
Function:onStatusStop()
Parameter:NULL
Description:
*******************************/
function onStatusStop()
{
    uni_OperationProcess = Macro_Process_OpenPort;
    queryStatus();
}

/******************************
Function:queryStatus()
Parameter:NULL
Description:
*******************************/
function queryStatus()
{
	if(KIOSKOCX==null)
	{
		return false;
	}	                           
	
	//*****************************************************************************************************************
	//Define veriables
	var		tempReturnValue = KIOSK_SUCCESS;
	var		PrinterStatus = 0x00;
	var	statusInfo = false;
	
	//*****************************************************************************************************************
	//Set timeouts
	if(SetTimeouts(1000, 1000))
	{

	    //*****************************************************************************************************************
	    //Query status
	    if(uni_OperationProcess == Macro_Process_StatusMonitor)
	    {
		    //*************************************************************************************************************
		    //Query status
		    form.statusResultName.value = "Start status monitor...";     
		    PrinterStatus = 0x00;
    		
		    PrinterStatus = KIOSKOCX.KIOSKGetRTQueryStatus(m_hPort,iPortType);//penghaiying

		    if(PrinterStatus >= KIOSK_SUCCESS)
		    {
			    uni_OperationProcess = Macro_Process_OpenPort;
			    return;
			    //break;
		    }

		    //*************************************************************************************************************
		    //Parse status
		    statusInfo = ((PrinterStatus & 0x01) == 0x01)? true: false;
		    parseStatus(form.icoHeadUp,statusInfo);
		    statusInfo = ((PrinterStatus & 0x02) == 0x02)? true: false;
		    parseStatus(form.icoPaperEnd,statusInfo);
		    statusInfo = ((PrinterStatus & 0x04) == 0x04)? true: false;
		    parseStatus(form.icoCutterError,statusInfo);
		    statusInfo = ((PrinterStatus & 0x08) == 0x08)? true: false;
		    parseStatus(form.icoHeadHot,statusInfo);
		    statusInfo = ((PrinterStatus & 0x10) == 0x10)? true: false;
		    parseStatus(form.icoPaperNearEnd,statusInfo);
    		
		    /*
		    var project = new Lock(); 
		    project.lock();
		    timeout();
		    project.unlock();
		    /*
		    if(timerunning){
    	        clearTimeout(timeID);
            }
            timerunning = false;
		    timeout();*/
	    }
	}
	
	/*
	form.icoHeadUp.src = icoInit;
	form.icoPaperEnd.src = icoInit;
	form.icoCutterError.src = icoInit;
	form.icoHeadHot.src = icoInit;
	form.icoPaperNearEnd.src = icoInit;*/
	uni_OperationProcess = Macro_Process_OpenPort;
	
	SetTimeouts(2000, 2000);
	grayControl();
	
	if(uni_OperationProcess == Macro_Process_OpenPort)
	{
		form.statusResultName.value = "Stop status monitor!";
	}	
	else
	{
		form.statusResultName.value = "Port Closed!";
	}	
	return true;
}


/******************************
Function:timeout()
Parameter:NULL
Description:
*******************************/
function timeout()
{
    timeID = setTimeout("timeout()",800);
    timerunning = true;
}

/******************************
Function:parseStatus() 
Parameter:obj,status
Description:
*******************************/
function parseStatus(obj,status) { 
    if (!status) {
        obj.src = icoRight;
    }else{
        obj.src = icoErr;
    }
}

/******************************
Function:onPrintText() 
Parameter:NULL
Description:
*******************************/
function onPrintText() 
{
	uni_OperationProcess = Macro_Process_Print;
	//Macro_PrintContent_Text="12121212";
	uni_PrintContent = Macro_PrintContent_Text;
	
    printProc();
}

/******************************
Function:onPrintBitmap() 
Parameter:NULL
Description:
*******************************/
function onPrintBitmap() 
{
    uni_OperationProcess = Macro_Process_Print;;
    uni_PrintContent = Macro_PrintContent_Image;
   
	printProc();
}

/**********************************************************************************************************************
  Function: Print sample prospectus.
  Input:	pData
  Output:	null	  
  Return:   void
**********************************************************************************************************************/
function printProc()
{
	if(KIOSKOCX == null)
	{
		return false;
	}
	
	var	startDocSigned = false;
	var	NibbleParBeginSigned = false;
	var ReturnValue = false;
	
	var temp = getRadioValue("print_mode_selecting");
	switch(temp) {
	case "radio_standard":
	    uni_PrintMode = KIOSK_PRINT_MODE_STANDARD;
		break;
	case "radio_page":
	    uni_PrintMode = KIOSK_PRINT_MODE_PAGE;
		break;
	default:
	}
	
	temp = getRadioValue("presenter_setting");
	switch(temp) {
	case "radio_56mm":
	    uni_PageWidth = Macro_PageWidth_56mm;
		break;
	case "radio_80mm":
	    uni_PageWidth = Macro_PageWidth_80mm;
		break;
	case "radio_210mm":
	    uni_PageWidth = Macro_PageWidth_210mm;
	    break;
	default:
	}
	
	temp = getRadioValue("resolution_setting");
	switch(temp) {
	case "radio_203dpi":
	    uni_Resolution = Macro_Resolution_203DPI;
		break;
	case "radio_300dpi":
	    uni_Resolution = Macro_Resolution_300DPI;
		break;
	default:	
	}
	
	//*****************************************************************************************************************
	//Driver port
	if (iPortType == KIOSK_DRV)
	{
		if(KIOSKOCX.KIOSKStartDoc(m_hPort) != KIOSK_SUCCESS)
		{
			PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue);
		}
	}
	startDocSigned = true;

    //*****************************************************************************************************************
	//Save printing data to file
	if (form.checkBoxSendData.checked) {
		if (KIOSKOCX.KIOSKBeginSaveToFile(m_hPort,saveFilePath+"Test.dat",false) != KIOSK_SUCCESS){ //penghaiying needtest
		    PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue);
		}
	}
	else
	{
		if(!SetTimeouts(1000, 10000))
		{
			PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue);
		}
	}

	//*****************************************************************************************************************
	//Nibble Parallel Port begin send data
	if(iPortType == KIOSK_NIBBLEPAR && !NibbleParBeginSigned)
	{
		if(KIOSKOCX.KIOSKNibbleParPrintToMemory() != KIOSK_SUCCESS)
		{
			PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue);
		}
	}
	NibbleParBeginSigned = true;
 
    //*****************************************************************************************************************
	//Print sample
	if(uni_PrintMode == KIOSK_PRINT_MODE_STANDARD)
	{
		switch(uni_PageWidth)
		{
		case Macro_PageWidth_56mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_StandardMode_56mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_StandardMode_56mm_300();
			}
 			break;
 		case Macro_PageWidth_80mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_StandardMode_80mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_StandardMode_80mm_300();
			}
 			break;
 		case Macro_PageWidth_210mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_StandardMode_210mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_StandardMode_210mm_300();
			}
 			break;
		}
	}
	else if(uni_PrintMode == KIOSK_PRINT_MODE_PAGE)
	{
		switch(uni_PageWidth)
		{
 		case Macro_PageWidth_56mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_PageMode_56mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_PageMode_56mm_300();
			}
			break;
 		case Macro_PageWidth_80mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_PageMode_80mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_PageMode_80mm_300();
			}
 			break;
		case Macro_PageWidth_210mm:
			if(uni_Resolution == Macro_Resolution_203DPI)
			{
				ReturnValue = Sample_PageMode_210mm_203();
			}
			else if(uni_Resolution == Macro_Resolution_300DPI)
			{
				ReturnValue = Sample_PageMode_210mm_300();
			}
			break;
		}
		
		KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	}

    PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue);
	return true;
}

/**********************************************************************************************************************
  Function: Print sample prospectus.
  Input:	pData
  Output:	null	  
  Return:   void
**********************************************************************************************************************/
function PrintProc_ExitLine(startDocSigned,NibbleParBeginSigned,ReturnValue) {
    //*****************************************************************************************************************
	//Nibble Parallel Port print data
	if(iPortType == KIOSK_NIBBLEPAR && NibbleParBeginSigned)
	{
		KIOSKOCX.KIOSKNibbleParFlushMemory();
	}
	//*****************************************************************************************************************
	//Save printing data to file 
	if (form.checkBoxSendData.checked) 
	{
		KIOSKOCX.KIOSKEndSaveToFile(m_hPort);
	}
	else
	{
		SetTimeouts(2000, 2000);
	}

	//*****************************************************************************************************************
	//End document
	if(iPortType == KIOSK_DRV && startDocSigned)
	{
		KIOSKOCX.KIOSKEndDoc(m_hPort);
	}

    grayControl();
	if(uni_OperationProcess == Macro_Process_ClosePort)
	{
		if(ReturnValue)
		{
			form.statusResultName.value = "Port Closed, print successfully!";
		}
		else
		{			
			form.statusResultName.value = "Port Closed, print failed!";
		}		
	}
	else
	{
		uni_OperationProcess = Macro_Process_OpenPort;
		if(ReturnValue)
		{
			form.statusResultName.value = "Print successfully!";
		}
		else
		{			
			form.statusResultName.value = "Print failed!";
		}
	}
	grayControl();
	ReturnValue = true;
	return true;
}

/******************************
Function:onClosePort() 
Parameter:NULL
Description:
*******************************/
function onClosePort()
{
	var nRet = KIOSK_SUCCESS;
	if(KIOSKOCX!=null)
	{	
		switch(iPortType)
		{
		case KIOSK_COM:
			nRet = KIOSKOCX.KIOSKCloseCom(m_hPort);
			break;
		case KIOSK_LPT:
			nRet = KIOSKOCX.KIOSKCloseDrvLpt();
			break;
		case KIOSK_NIBBLEPAR:
			nRet = KIOSKOCX.KIOSKCloseNibblePar();
			break;
		case KIOSK_USB:
			nRet = KIOSKOCX.KIOSKCloseUsb(m_hPort);
			break;
		case KIOSK_USBCLASSS:
			nRet = KIOSKOCX.KIOSKCloseUsb(m_hPort);
			break;
		case KIOSK_DRV:
			nRet = KIOSKOCX.KIOSKCloseDrv(m_hPort);
			break;
		}
	
	    if (nRet == KIOSK_SUCCESS) {
	        m_hPort = -1;
	        form.statusResultName.value = "Close port successfully!";
	        uni_OperationProcess = Macro_Process_ClosePort;
	    }else{
	        form.statusResultName.value = "Close port failed!";
	    }
		grayControl();		
	}	
}

/******************************
Function:onExit() 
Parameter:NULL
Description:
*******************************/
function onExit()
{
	close();
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 210mm in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_210mm()
{
	//*****************************************************************************************************************
	//Define veriables
	var returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, 203, 203);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 100, 1500);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	
	//*****************************************************************************************************************
	//Set line spacing
	tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 20);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}

	//*****************************************************************************************************************
	//Print text
	if(uni_PrintContent == Macro_PrintContent_Text)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 500, 3, 3,
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 5);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 40);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Set rihgt spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  In order to providing the user who use the KIOSK printer to carry on two of developments, KIOSKDLL were developed by the Shandong New Beiyang Technology Information Company Co.Ltd.", 
													  0, 2, 1,  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  We supply this sample to show our KIOSKDLL's function. You can also rewoke the resident sample by yourself.", 
													  0, 2, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
		
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 4);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support port:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "COM", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "LPT", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "USB", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Driver", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support system:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2000", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2003", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType , 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows XP", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows Vista", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support barcode:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN13", 1200, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN8", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF", 1200, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
	
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128", 1200, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "PDF417", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support equipment:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-T080", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W080", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-S216", 1200, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-L216II", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W056", 800, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Paper   width:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "210mm(216mm max)",	440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   speed:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.125mm/s(203DPI)", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines( m_hPort,iPortType, 2 );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.100mm/s(300DPI)", 440, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
	}
	//*****************************************************************************************************************
	//Print image
	else if(uni_PrintContent == Macro_PrintContent_Image)
	{
		//*************************************************************************************************************
		//Download bitmap
		tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Map.bmp@", 1, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   Bitmap:", 0, 2, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print bitmap
		tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 500, KIOSK_BITMAP_PRINT_DOUBLE_WIDTH);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 95, 
														  KIOSK_BARCODE_TYPE_UPC_A, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 95, 
														   KIOSK_BARCODE_TYPE_UPC_E, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 95, 
														   KIOSK_BARCODE_TYPE_JAN13, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:", 5, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 95, 
														   KIOSK_BARCODE_TYPE_JAN8, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 95, 
														   KIOSK_BARCODE_TYPE_CODE39, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 95, 
														   KIOSK_BARCODE_TYPE_ITF, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:", 95, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A", 95, 
			                                               KIOSK_BARCODE_TYPE_CODEBAR, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:", 95, 1, 1, 
											          KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 95, 
			                                               KIOSK_BARCODE_TYPE_CODE93, 5, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:", 95, 1, 1, 
			                                          KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", 95, 
			                                               KIOSK_BARCODE_TYPE_CODE128, 5, 60, KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;
		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;
	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 56mm 203 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_56mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var		returnValue = false;
	var		tempReturnValue = KIOSK_SUCCESS;
	var		leftMargin = 5;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 10, 450);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 50, 
													  2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------",
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  215, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  215, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  215, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-BOLD", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line		
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-90",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_CLOCKWISE_90);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}	

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------Logo1-------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 80,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------Logo2-------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 2, 80, KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890",
														  leftMargin, KIOSK_BARCODE_TYPE_UPC_A, 
														  3, 50, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 
														   leftMargin, KIOSK_BARCODE_TYPE_UPC_E, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 
														   leftMargin, KIOSK_BARCODE_TYPE_JAN13, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 
													       leftMargin,KIOSK_BARCODE_TYPE_JAN8, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 
														   leftMargin, KIOSK_BARCODE_TYPE_CODE39,
														   2, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 
														   leftMargin, KIOSK_BARCODE_TYPE_ITF, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODEBAR, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE93, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE128, 
														   2, 50, KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 56mm 203 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_56mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;
	var	leftMargin = 5;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*************************************************************************************************************
	//Download bitmap
	if(uni_PrintContent == Macro_PrintContent_Image)
	{
		tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}	

	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  450, 700, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}	
			
			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else
		{
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  450, 400, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}		

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",
														  50, 50, 2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------", 
														  leftMargin, 80, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------",  
														  leftMargin, 100, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 125,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  215, 125,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 150, 1, 1,KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  215, 150,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 175, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  215, 175,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL",  
														  leftMargin, 220,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-BOLD",  
														  leftMargin, 245,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
														  leftMargin, 270,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
														  leftMargin, 295,1, 1,KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
														  leftMargin, 320,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------",  
														  leftMargin, 350,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-------------Logo1--------------",  
														      leftMargin, 370, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 
																	  80, 480,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-------------Logo2--------------",  
															  leftMargin, 530,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		
			//*********************************************************************************************************
			//Print bitmap
 			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 2, 
																	  80, 640, KIOSK_BITMAP_PRINT_QUADRUPLE);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 450, 1400, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", leftMargin, 50, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 110, 
															   KIOSK_BARCODE_TYPE_UPC_A, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", leftMargin, 200, 1, 1,
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 260,
															   KIOSK_BARCODE_TYPE_UPC_E, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", leftMargin, 350, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", leftMargin, 410,
															   KIOSK_BARCODE_TYPE_JAN13, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", leftMargin, 500, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", leftMargin, 560,
															   KIOSK_BARCODE_TYPE_JAN8, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", leftMargin, 650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", leftMargin, 710,
															   KIOSK_BARCODE_TYPE_CODE39, 2, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", leftMargin, 800, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 860,
															   KIOSK_BARCODE_TYPE_ITF, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", leftMargin, 950, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", leftMargin, 1010,
															   KIOSK_BARCODE_TYPE_CODEBAR, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", leftMargin, 1100, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1160,
															   KIOSK_BARCODE_TYPE_CODE93, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", leftMargin, 1250, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", leftMargin, 1310,
															   KIOSK_BARCODE_TYPE_CODE128, 2, 50, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 56mm 300 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_56mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var		returnValue = false;
	var		tempReturnValue = KIOSK_SUCCESS;
	var		leftMargin = 5;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 10, 600);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 50, 
													  2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------",
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  300, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  300, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  300, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-BOLD", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line		
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-90",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_CLOCKWISE_90);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------------------------",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}	

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------Logo1-------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 180,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "--------------Logo2-------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 2, 180, KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890",
														  leftMargin, KIOSK_BARCODE_TYPE_UPC_A, 
														  4, 60, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 
														   leftMargin, KIOSK_BARCODE_TYPE_UPC_E, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 
														   leftMargin, KIOSK_BARCODE_TYPE_JAN13, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 
													       leftMargin,KIOSK_BARCODE_TYPE_JAN8, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 
														   leftMargin, KIOSK_BARCODE_TYPE_CODE39,
														   3, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 
														   leftMargin, KIOSK_BARCODE_TYPE_ITF, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODEBAR, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE93, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE128, 
														   3, 60,KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 56mm 300 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_56mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;
	var	leftMargin = 5;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*************************************************************************************************************
	//Download bitmap
	if(uni_PrintContent == Macro_PrintContent_Image)
	{
		tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}	

	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  600, 900, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else
		{
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  600, 500, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}		

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",
														  60, 70, 2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------", 
														  leftMargin, 120, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------",  
														  leftMargin, 140, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 180,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  300, 180,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 215, 1, 1,KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  300, 215,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 250, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  300, 250,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL",  
														  leftMargin, 305,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-BOLD",  
														  leftMargin, 340,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
														  leftMargin, 375,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
														  leftMargin, 410,1, 1,KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
														  leftMargin, 445,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------------------------",  
														  leftMargin, 480,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-------------Logo1--------------",  
														      leftMargin, 510, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 
																	  180, 620,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-------------Logo2--------------",  
															  leftMargin, 680,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		
			//*********************************************************************************************************
			//Print bitmap
 			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 2, 
																	  180, 800, KIOSK_BITMAP_PRINT_QUADRUPLE);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 600, 1900, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", leftMargin, 50, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 120, 
															   KIOSK_BARCODE_TYPE_UPC_A,4, 60, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", leftMargin, 250, 1, 1,
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 320,
															   KIOSK_BARCODE_TYPE_UPC_E, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", leftMargin, 450, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", leftMargin, 520,
															   KIOSK_BARCODE_TYPE_JAN13, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", leftMargin, 650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", leftMargin, 720,
															   KIOSK_BARCODE_TYPE_JAN8, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", leftMargin, 850, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", leftMargin, 920,
															   KIOSK_BARCODE_TYPE_CODE39, 3, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", leftMargin, 1050, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1120,
															   KIOSK_BARCODE_TYPE_ITF, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", leftMargin, 1250, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", leftMargin, 1320,
															   KIOSK_BARCODE_TYPE_CODEBAR, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", leftMargin, 1450, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1520,
															   KIOSK_BARCODE_TYPE_CODE93, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", leftMargin, 1650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", leftMargin, 1720,
															   KIOSK_BARCODE_TYPE_CODE128, 3, 60, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 80mm 203 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_80mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var		returnValue = false;
	var		tempReturnValue = KIOSK_SUCCESS;
	var		leftMargin = 95;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 10, 640);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 150, 
													  2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------",
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  330, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  330, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  330, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-BOLD", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line		
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-90",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_CLOCKWISE_90);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}	

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "---------------Logo1---------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 180,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "---------------Logo2---------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 2, 180, KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890",
														  leftMargin, KIOSK_BARCODE_TYPE_UPC_A, 
														  3, 50, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 
														   leftMargin, KIOSK_BARCODE_TYPE_UPC_E, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 
														   leftMargin, KIOSK_BARCODE_TYPE_JAN13, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 
													       leftMargin,KIOSK_BARCODE_TYPE_JAN8, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 
														   leftMargin, KIOSK_BARCODE_TYPE_CODE39,
														   2, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 
														   leftMargin, KIOSK_BARCODE_TYPE_ITF, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODEBAR, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE93, 
														   3, 50, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE128, 
														   2, 50, KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 80mm 203 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_80mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;
	var	leftMargin = 95;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*************************************************************************************************************
	//Download bitmap
	if(uni_PrintContent == Macro_PrintContent_Image)
	{
		tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}	

	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  640, 700, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}		
			
			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else
		{
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  640, 400, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}		

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",
														  150, 50, 2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------", 
														  leftMargin, 80, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------",  
														  leftMargin, 100, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 125,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  330, 125,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 150, 1, 1,KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  330, 150,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 175, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  330, 175,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL",  
														  leftMargin, 220,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-BOLD",  
														  leftMargin, 245,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
														  leftMargin, 270,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
														  leftMargin, 295,1, 1,KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
														  leftMargin, 320,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------",  
														  leftMargin, 350,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "---------------Logo1---------------",  
														      leftMargin, 370, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 
																	  180, 480,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "---------------Logo2---------------",  
															  leftMargin, 530,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		
			//*********************************************************************************************************
			//Print bitmap
 			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 2, 
																	  180, 640, KIOSK_BITMAP_PRINT_QUADRUPLE);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 640, 1400, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", leftMargin, 50, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 110, 
															   KIOSK_BARCODE_TYPE_UPC_A, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", leftMargin, 200, 1, 1,
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 260,
															   KIOSK_BARCODE_TYPE_UPC_E, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", leftMargin, 350, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", leftMargin, 410,
															   KIOSK_BARCODE_TYPE_JAN13, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", leftMargin, 500, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", leftMargin, 560,
															   KIOSK_BARCODE_TYPE_JAN8, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", leftMargin, 650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", leftMargin, 710,
															   KIOSK_BARCODE_TYPE_CODE39, 2, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", leftMargin, 800, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 860,
															   KIOSK_BARCODE_TYPE_ITF, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", leftMargin, 950, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", leftMargin, 1010,
															   KIOSK_BARCODE_TYPE_CODEBAR, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", leftMargin, 1100, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1160,
															   KIOSK_BARCODE_TYPE_CODE93, 3, 50, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", leftMargin, 1250, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", leftMargin, 1310,
															   KIOSK_BARCODE_TYPE_CODE128, 2, 50, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 80mm 300 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_80mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var		returnValue = false;
	var		tempReturnValue = KIOSK_SUCCESS;
	var		leftMargin = 95;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 10, 800);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 200, 
													  2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------",
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  400, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  400, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Right Spacing", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
													  400, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-BOLD", 
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line		
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "FONTSTYLE-90",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_CLOCKWISE_90);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "-----------------------------------",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}	

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "---------------Logo1---------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*************************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 300,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "---------------Logo2---------------",  
														  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 2, 300, KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890",
														  leftMargin, KIOSK_BARCODE_TYPE_UPC_A, 
														  4, 60, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 
														   leftMargin, KIOSK_BARCODE_TYPE_UPC_E, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 
														   leftMargin, KIOSK_BARCODE_TYPE_JAN13, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 
													       leftMargin,KIOSK_BARCODE_TYPE_JAN8, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 
														   leftMargin, KIOSK_BARCODE_TYPE_CODE39,
														   3, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 
														   leftMargin, KIOSK_BARCODE_TYPE_ITF, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODEBAR, 
														   4, 60,KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE93, 
														   4, 60, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:",  
													  leftMargin, 1, 1, KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345",  
														   leftMargin, KIOSK_BARCODE_TYPE_CODE128, 
														   3, 60,KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 80mm 300 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_80mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;
	var	leftMargin = 95;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*************************************************************************************************************
	//Download bitmap
	if(uni_PrintContent == Macro_PrintContent_Image)
	{
		tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}	

	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Image)
		{			
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  800, 900, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Kitty.bmp@"+bmpPath+"Look.bmp@", 1, 2);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else
		{
			//*********************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 
																		  800, 500, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}		

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",
														  200, 70, 2, 2, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------", 
														  leftMargin, 120, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------",  
														  leftMargin, 140, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 180,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  400, 180,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 1);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 215, 1, 1,KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  400, 215,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Right Spacing",  
														  leftMargin, 250, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer",  
														  400, 250,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-NORMAL",  
														  leftMargin, 305,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL );
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-BOLD",  
														  leftMargin, 340,1, 1, KIOSK_FONT_TYPE_STANDARD,KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType,"FONTSTYLE-UNDERLINE",  
														  leftMargin, 375,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-UNDERLINE",  
														  leftMargin, 410,1, 1,KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "FONTSTYLE-REVERSE",  
														  leftMargin, 445,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set right spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "-----------------------------------",  
														  leftMargin, 480,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------Logo1----------------",  
														      leftMargin, 510, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
			
			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 
																	  300, 620,KIOSK_BITMAP_PRINT_QUADRUPLE);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "--------------Logo2----------------",  
															  leftMargin, 680,1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		
			//*********************************************************************************************************
			//Print bitmap
 			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 2, 
																	  300, 800, KIOSK_BITMAP_PRINT_QUADRUPLE);
 			if(tempReturnValue != KIOSK_SUCCESS)
 			{
 				return returnValue;

 			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 10, 10, 800, 1900, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", leftMargin, 50, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 120, 
															   KIOSK_BARCODE_TYPE_UPC_A,4, 60, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", leftMargin, 250, 1, 1,
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", leftMargin, 320,
															   KIOSK_BARCODE_TYPE_UPC_E, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", leftMargin, 450, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", leftMargin, 520,
															   KIOSK_BARCODE_TYPE_JAN13, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", leftMargin, 650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", leftMargin, 720,
															   KIOSK_BARCODE_TYPE_JAN8, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", leftMargin, 850, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", leftMargin, 920,
															   KIOSK_BARCODE_TYPE_CODE39, 3, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", leftMargin, 1050, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1120,
															   KIOSK_BARCODE_TYPE_ITF, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
														       KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", leftMargin, 1250, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", leftMargin, 1320,
															   KIOSK_BARCODE_TYPE_CODEBAR, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", leftMargin, 1450, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", leftMargin, 1520,
															   KIOSK_BARCODE_TYPE_CODE93, 4, 60, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", leftMargin, 1650, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", leftMargin, 1720,
															   KIOSK_BARCODE_TYPE_CODE128, 3, 60, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 210mm 203 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_210mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 100, 1500);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set line spacing
	tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 20);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Print text or image 
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Map.bmp@", 1, 1);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
			                                          500, 2, 2,
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 4);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 40);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set rihgt spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  In order to providing the user who use the KIOSK printer to carry on two of developments, KIOSKOCX were developed by the Shandong New Beiyang Technology Information Company Co.Ltd.", 
													  0, 1, 1,  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  We supply this sample to show our KIOSKOCX's function. You can also rewoke the resident sample by yourself.", 
													  0, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 4);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support port:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "COM", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "LPT", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "NibblePar", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "USB API", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "USB Class", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Driver", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support system:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2000", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2003", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows XP", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType , 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows Vista", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 7", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support barcode:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN13", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN8", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "PDF417", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support equipment:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-T080", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W080", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-S216", 1000, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-L216", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W056", 700, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Paper   width:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "210mm(216mm max)",	400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   speed:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.125mm/s(203DPI)", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines( m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.100mm/s(300DPI)", 400, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   Bitmap:", 0, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 500, KIOSK_BITMAP_PRINT_DOUBLE_WIDTH);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 100, 
														  KIOSK_BARCODE_TYPE_UPC_A, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 100, 
														   KIOSK_BARCODE_TYPE_UPC_E, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 100, 
														   KIOSK_BARCODE_TYPE_JAN13, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 100, 
														   KIOSK_BARCODE_TYPE_JAN8, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 100, 
														   KIOSK_BARCODE_TYPE_CODE39, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 100, 
														   KIOSK_BARCODE_TYPE_ITF, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A", 100, 
			                                               KIOSK_BARCODE_TYPE_CODEBAR, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:", 100, 1, 1, 
											          KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 100, 
			                                               KIOSK_BARCODE_TYPE_CODE93, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:", 100, 1, 1, 
			                                          KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", 100, 
			                                               KIOSK_BARCODE_TYPE_CODE128, 5, 100, KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort, iPortType);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 210mm 203 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_210mm_203()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set line spacing
	tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 20);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Text)
		{
			//*****************************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 1500, 1500, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*****************************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 1500, 1800, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Map.bmp@", 1, 1);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer", 500, 100, 2, 2, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 40);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set rihgt spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "  In order to providing the user who use the KIOSK printer to carry on two of developments, KIOSKDLL were developed by the Shandong New Beiyang Technology Information Company Co.Ltd.", 
														  0, 200, 1, 1,  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "  We supply this sample to show our KIOSKDLL's function. You can also rewoke the resident sample by yourself.", 
														 0, 350, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support port:", 0, 480, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "COM", 400, 480, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "LPT", 700, 480, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "NibblePar", 900, 480, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "USB API", 400, 550, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "USB Class", 700, 550, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Driver", 900, 550, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support system:", 0, 655, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 2000", 400, 655, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 2003", 700, 655, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows XP", 1000, 655, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows Vista", 400, 725, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 7", 700, 725, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support barcode:", 0, 830, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A", 400, 830, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E", 700, 830, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "JAN13", 1000, 830, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "JAN8", 400, 900, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39", 700, 900, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF", 1000, 900, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR", 400, 970, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93", 700, 970, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128", 1000, 970, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "PDF417", 400, 1040, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support equipment:", 0, 1145, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-T080", 400, 1145, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-W080", 700, 1145, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-S216", 1000, 1145, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-L216", 400, 1215, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-W056", 700, 1215, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Paper   width:", 0, 1290, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "210mm(216mm max)",	400, 1290, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Print   speed:", 0, 1405, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Max.125mm/s(203DPI)", 400, 1405, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Max.100mm/s(300DPI)", 400, 1475, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Print   Bitmap:", 0, 1580, 1, 1, 
															  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 500, 1650, 
																	  KIOSK_BITMAP_PRINT_DOUBLE_WIDTH);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 1500, 2800, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", 100, 100, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", 100, 250, 
															   KIOSK_BARCODE_TYPE_UPC_A, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", 100, 400, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", 100, 550,
															   KIOSK_BARCODE_TYPE_UPC_E, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", 100, 700, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", 100, 850,
															   KIOSK_BARCODE_TYPE_JAN13, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", 100, 1000, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", 100, 1150, 
															   KIOSK_BARCODE_TYPE_JAN8, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", 100, 1300, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", 100, 1450,
															   KIOSK_BARCODE_TYPE_CODE39, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", 100, 1600, 1, 1, 
														KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", 100, 1750,
															   KIOSK_BARCODE_TYPE_ITF, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", 100, 1900, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", 100, 2050,
															   KIOSK_BARCODE_TYPE_CODEBAR, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", 100, 2200,1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", 100, 2350, 
															   KIOSK_BARCODE_TYPE_CODE93, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", 100, 2500, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", 100, 2650, 
															   KIOSK_BARCODE_TYPE_CODE128, 5, 100, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 210mm 300 dpi in standard mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_StandardMode_210mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_STANDARD);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
    tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set left margin and area
    tempReturnValue = KIOSKOCX.KIOSKSetLeftMarginAndAreaWidth(m_hPort, iPortType, 100, 2350);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set line spacing
	tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 20);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Print text or image 
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		//*************************************************************************************************************
		//Download bitmap
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Map.bmp@", 1, 1);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "KIOSK Printer", 
			                                          800, 3, 3,
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 5);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 40);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set rihgt spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  In order to providing the user who use the KIOSK printer to carry on two of developments, KIOSKOCX were developed by the Shandong New Beiyang Technology Information Company Co.Ltd.", 
													  0, 1, 1,  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "  We supply this sample to show our KIOSKOCX's function. You can also rewoke the resident sample by yourself.", 
													  0, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 4);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support port:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "COM", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "LPT", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "NibblePar", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "USB API", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "USB Class", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Driver", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support system:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2000", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 2003", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows XP", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType , 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows Vista", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Windows 7", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support barcode:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN13", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "JAN8", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType,2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "PDF417", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Support equipment:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-T080", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W080", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-S216", 1300, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-L216", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "BK-W056", 900, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Paper   width:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "210mm(216mm max)",	500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   speed:", 0, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.125mm/s(203DPI)", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines( m_hPort,iPortType, 2);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Max.100mm/s(300DPI)", 500, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "Print   Bitmap:", 0, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLine(m_hPort,iPortType);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPrintBmpInFlash(m_hPort, iPortType, 1, 900, KIOSK_BITMAP_PRINT_DOUBLE_WIDTH);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Feed Line
			tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort,iPortType, 3);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-A:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 100, 
														  KIOSK_BARCODE_TYPE_UPC_A, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														  KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "UPC-E:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "01234567890", 100, 
														   KIOSK_BARCODE_TYPE_UPC_E, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-13:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "012345678901", 100, 
														   KIOSK_BARCODE_TYPE_JAN13, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "EAN-8:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456", 100, 
														   KIOSK_BARCODE_TYPE_JAN8, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE39:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "*0123456789*", 100, 
														   KIOSK_BARCODE_TYPE_CODE39, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "ITF:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 100, 
														   KIOSK_BARCODE_TYPE_ITF, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODEBAR:", 100, 1, 1, 
													  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "A0123456789A", 100, 
			                                               KIOSK_BARCODE_TYPE_CODEBAR, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE93:", 100, 1, 1, 
											          KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "0123456789", 100, 
			                                               KIOSK_BARCODE_TYPE_CODE93, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
														   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);	
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKTextout(m_hPort, iPortType, "CODE128:", 100, 1, 1, 
			                                          KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 2);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", 100, 
			                                               KIOSK_BARCODE_TYPE_CODE128, 5, 100, KIOSK_FONT_TYPE_STANDARD,
														   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Feed Line
		tempReturnValue = KIOSKOCX.KIOSKFeedLines(m_hPort, iPortType, 3);		
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

/**********************************************************************************************************************
  Function: Print sample prospectus of 210mm 300 dpi in page mode.
  Input:	null.
  Output:	null	  
  Return:   true indicates success, false indicates failure.
**********************************************************************************************************************/
function Sample_PageMode_210mm_300()
{
	//*****************************************************************************************************************
	//Define veriables
	var	returnValue = false;
	var	tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Reset printer
	tempReturnValue = KIOSKOCX.KIOSKReset(m_hPort,iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set mode
	tempReturnValue = KIOSKOCX.KIOSKSetMode(m_hPort,iPortType, KIOSK_PRINT_MODE_PAGE);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set motion unit
  tempReturnValue = KIOSKOCX.KIOSKSetMotionUnit(m_hPort,iPortType, uni_Resolution, uni_Resolution);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set right spacing
	tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Set line spacing
	tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 20);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Print text or image
	if((uni_PrintContent == Macro_PrintContent_Text) || (uni_PrintContent == Macro_PrintContent_Image))
	{
		if(uni_PrintContent == Macro_PrintContent_Text)
		{
			//*****************************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 2350, 1500, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
		else if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*****************************************************************************************************************
			//Set left margin and area
			tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 2350, 1800, KIOSK_AREA_LEFT_TO_RIGHT);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Download bitmap
			tempReturnValue = KIOSKOCX.KIOSKPreDownloadBmpToFlash(m_hPort, iPortType, bmpPath+"Map.bmp@", 1, 1);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "KIOSK Printer", 800, 100, 3, 3, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set line spacing
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 40);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Set rihgt spacing
		tempReturnValue = KIOSKOCX.KIOSKSetRightSpacing(m_hPort, iPortType, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "  In order to providing the user who use the KIOSK printer to carry on two of developments, KIOSKDLL were developed by the Shandong New Beiyang Technology Information Company Co.Ltd.", 
														  0, 200, 1, 1,  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "  We supply this sample to show our KIOSKDLL's function. You can also rewoke the resident sample by yourself.", 
														 0, 300, 1, 1, KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
		
		tempReturnValue = KIOSKOCX.KIOSKSetLineSpacing(m_hPort, iPortType, 15);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support port:", 0, 430, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "COM", 500, 430, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "LPT", 900, 430, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "NibblePar", 1300, 430, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "USB API", 500, 500, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "USB Class", 900, 500, 1, 1, 
													      KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Driver", 1300, 500, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support system:", 0, 605, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 2000", 500, 605, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 2003", 900, 605, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows XP", 1300, 605, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows Vista", 500, 675, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Windows 7", 900, 675, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THIN_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support barcode:", 0, 780, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A", 500, 780, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E", 900, 780, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "JAN13", 1300, 780, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "JAN8", 500, 850, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39", 900, 850, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF", 1300, 850, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR", 500, 920, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93", 900, 920, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128", 1300, 920, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "PDF417", 500, 990, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_THICK_UNDERLINE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Support equipment:", 0, 1095, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-T080", 500, 1095, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-W080", 900, 1095, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-S216", 1300, 1095, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-L216", 500, 1165, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "BK-W056", 900, 1165, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_REVERSE);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Paper   width:", 0, 1240, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "210mm(216mm max)",	500, 1240, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Print   speed:", 0, 1355, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Max.125mm/s(203DPI)", 500, 1355, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Max.100mm/s(300DPI)", 500, 1425, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print image
		if(uni_PrintContent == Macro_PrintContent_Image)
		{
			//*********************************************************************************************************
			//Text setting
			tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "Print   Bitmap:", 0, 1530, 1, 1, 
															  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_BOLD);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}

			//*********************************************************************************************************
			//Print bitmap
			tempReturnValue = KIOSKOCX.KIOSKPagePrintBmpInFlash(m_hPort, iPortType, 1, 900, 1600, 
																	  KIOSK_BITMAP_PRINT_DOUBLE_WIDTH);
			if(tempReturnValue != KIOSK_SUCCESS)
			{
				return returnValue;

			}
		}
	}
	//*****************************************************************************************************************
	//Print barcode
	else if(uni_PrintContent == Macro_PrintContent_Barcode)
	{
		//*************************************************************************************************************
		//Set left margin and area
		tempReturnValue = KIOSKOCX.KIOSKPageSetAreaAndDirection(m_hPort, iPortType, 100, 0, 1500, 2800, KIOSK_AREA_LEFT_TO_RIGHT);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-A:", 100, 100, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-A
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", 100, 250, 
															   KIOSK_BARCODE_TYPE_UPC_A, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "UPC-E:", 100, 400, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print UPC-E
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "01234567890", 100, 550,
															   KIOSK_BARCODE_TYPE_UPC_E, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 11);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-13:", 100, 700, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-13
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "012345678901", 100, 850,
															   KIOSK_BARCODE_TYPE_JAN13, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "EAN-8:", 100, 1000, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print JAN-8
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456", 100, 1150, 
															   KIOSK_BARCODE_TYPE_JAN8, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 7);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE39:", 100, 1300, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*****************************************************************************************************************
		//Print CODE39
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "*0123456789*", 100, 1450,
															   KIOSK_BARCODE_TYPE_CODE39, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "ITF:", 100, 1600, 1, 1, 
														KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print ITF
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", 100, 1750,
															   KIOSK_BARCODE_TYPE_ITF, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODEBAR:", 100, 1900, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODEBAR
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "A0123456789A", 100, 2050,
															   KIOSK_BARCODE_TYPE_CODEBAR, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 12);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE93:", 100, 2200,1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, KIOSK_FONT_STYLE_NORMAL);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE93
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "0123456789", 100, 2350, 
															   KIOSK_BARCODE_TYPE_CODE93, 5, 100, KIOSK_FONT_TYPE_STANDARD, 
															   KIOSK_HRI_POSITION_BELOW, 10);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
				return returnValue;

		}

		//*************************************************************************************************************
		//Text setting
		tempReturnValue = KIOSKOCX.KIOSKPageTextout(m_hPort, iPortType, "CODE128:", 100, 2500, 1, 1, 
														  KIOSK_FONT_TYPE_STANDARD, 0);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}

		//*************************************************************************************************************
		//Print CODE128
		tempReturnValue = KIOSKOCX.KIOSKPagePrintBarcode(m_hPort, iPortType, "{AAB{BCD{C012345", 100, 2650, 
															   KIOSK_BARCODE_TYPE_CODE128, 5, 100, KIOSK_FONT_TYPE_STANDARD,
															   KIOSK_HRI_POSITION_BELOW, 16);
		if(tempReturnValue != KIOSK_SUCCESS)
		{
			return returnValue;

		}
	}

	//*****************************************************************************************************************
	//Print
	tempReturnValue = KIOSKOCX.KIOSKPagePrint(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	
	//*****************************************************************************************************************
	//Clear buffer
	tempReturnValue = KIOSKOCX.KIOSKPageClear(m_hPort, iPortType);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}

	//*****************************************************************************************************************
	//Cut paper
	tempReturnValue = KIOSKOCX.KIOSKCutPaper(m_hPort, iPortType, 1, 0);
	if(tempReturnValue != KIOSK_SUCCESS)
	{
		return returnValue;

	}
	returnValue = true;
	return returnValue;
}

function onSelectPortCom() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//COM
	iPortType = KIOSK_COM;
	grayControl();
	selectPortControl();
	
	form.statusResultName.value = "Please configure COM parameters!";
}

function onSelectPortLpt() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//LPT
	iPortType = KIOSK_LPT;
	grayControl();
	selectPortControl();
	
	form.statusResultName.value = "Please configure LPT parameters!";
}

function onSelectPortNibblePar() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//Nibblepar
	iPortType = KIOSK_NIBBLEPAR;
	grayControl();
	selectPortControl();	
	
	form.statusResultName.value = "Please configure NibblePar parameters!";
}

function onSelectPortUsbApi() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//USBAPI
	iPortType = KIOSK_USB;
	grayControl();
	selectPortControl();	
	    
	form.statusResultName.value = "You select USB API!";
}

function onSelectPortUsbClass() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//USBClass
	iPortType = KIOSK_USBCLASSS;
	grayControl();
	selectPortControl();
	    
	form.statusResultName.value = "Please configure USB Class parameters!";
}

function onSelectPortDrv() {
    //*****************************************************************************************************************
	//Close port
	if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_StatusMonitor) || (uni_OperationProcess == Macro_Process_Print))
	{
		onClosePort();
	}

	//*****************************************************************************************************************
	//Driver
	iPortType = KIOSK_DRV;
	grayControl();
	selectPortControl();
	    
	form.statusResultName.value = "Please configure Driver parameters!";
}

/**********************************************************************************************************************
  Function: Gray control
  Input:	Process: Macro_Process_Init - Macro_Process_ClosePort
  Output:	null	  
  Return:   void
**********************************************************************************************************************/
function grayControl()
{
	//*****************************************************************************************************************
	//Init control or close port
	if((uni_OperationProcess == Macro_Process_Init) || (uni_OperationProcess == Macro_Process_ClosePort))
	{
		//*************************************************************************************************************
		//Port selecting
		selectPortControl();
		
		//*************************************************************************************************************
		//Function botton
		form.buttonOpenPort.disabled = false;
		form.buttonClosePort.disabled = true;

		//*************************************************************************************************************
		//Print mode selecting
		if(uni_PrintMode == KIOSK_PRINT_MODE_STANDARD)
		{
		    form.print_mode_selecting[0].checked = true;
		    form.print_mode_selecting[1].checked = false;
		}
		else
		{
		    form.print_mode_selecting[0].checked = false;
		    form.print_mode_selecting[1].checked = true;
		}
		form.print_mode_selecting[0].disabled = true;
		form.print_mode_selecting[1].disabled = true;

		//*************************************************************************************************************
		//Page Width Setting
		if(uni_PageWidth == Macro_PageWidth_56mm)
		{
		
			form.presenter_setting[0].checked = true;
			form.presenter_setting[1].checked = false;
			form.presenter_setting[2].checked = false;
		}
		else if(uni_PageWidth == Macro_PageWidth_80mm)
		{
			form.presenter_setting[0].checked = false;
			form.presenter_setting[1].checked = true;
			form.presenter_setting[2].checked = false;
		}
		else if(uni_PageWidth == Macro_PageWidth_210mm)
		{
			form.presenter_setting[0].checked = false;
			form.presenter_setting[1].checked = false;
			form.presenter_setting[2].checked = true;
		}
		form.presenter_setting[0].disabled = true;
		form.presenter_setting[1].disabled = true;
		form.presenter_setting[2].disabled = true;
		
		//*************************************************************************************************************
		//Resolution Setting
		if(uni_Resolution == Macro_Resolution_203DPI)
		{	
			form.resolution_setting[0].checked = true;
			form.resolution_setting[1].checked = false;		
		}
		else if(uni_Resolution == Macro_Resolution_300DPI)
		{
			form.resolution_setting[0].checked = false;
			form.resolution_setting[1].checked = true;
		}
		form.resolution_setting[0].disabled = true;
		form.resolution_setting[1].disabled = true;

		//*************************************************************************************************************
		//Print Sample	    
	    form.buttonPrintBitmap.disabled = true;
	    form.buttonPrint.disabled = true;
	    form.buttonPrintBarcode.disabled = true;
	    form.checkBoxSendData.disabled = true;

		//*************************************************************************************************************
		//Status
		form.icoHeadUp.src = icoInit;
	    form.icoPaperEnd.src = icoInit;
	    form.icoCutterError.src = icoInit;
	    form.icoHeadHot.src = icoInit;
	    form.icoPaperNearEnd.src = icoInit;

	    form.buttonStatusStart.disabled = true;
	    form.buttonStatusStop.disabled = true;	

		//*************************************************************************************************************
		//Show information
		if(uni_OperationProcess == Macro_Process_Init)
		{
			form.statusResultName.value = "Welcome to use KIOSKOCXDemo_JavaScript!";
		}
	}
	//*****************************************************************************************************************
	//Open port, status monitor or print process
	else if((uni_OperationProcess == Macro_Process_OpenPort) || (uni_OperationProcess == Macro_Process_Print) || (uni_OperationProcess == Macro_Process_StatusMonitor))
	{
		//*************************************************************************************************************
		//Function botton
		form.buttonOpenPort.disabled = true;
	    form.buttonPortSetting.disabled = true;
	    form.buttonClosePort.disabled = false;

		//*************************************************************************************************************
		//Print mode selecting and Page Width Setting
		if(uni_OperationProcess != Macro_Process_Print)
		{
			form.print_mode_selecting[0].disabled = false;
	        form.print_mode_selecting[1].disabled = false;
	        form.presenter_setting[0].disabled = false;
	        form.presenter_setting[1].disabled = false;
	        form.presenter_setting[2].disabled = false;
	        form.resolution_setting[0].disabled = false;
					form.resolution_setting[1].disabled = false;
		}
		else
		{
			form.print_mode_selecting[0].disabled = true;
	        form.print_mode_selecting[1].disabled = true;
	        form.presenter_setting[0].disabled = true;
	        form.presenter_setting[1].disabled = true;
	        form.presenter_setting[2].disabled = true;
	        form.resolution_setting[0].disabled = true;
					form.resolution_setting[1].disabled = true;
		}

		//*************************************************************************************************************
		//Print Sample
		if(uni_OperationProcess == Macro_Process_OpenPort)
		{
			form.buttonPrintBitmap.disabled = false;
	        form.buttonPrint.disabled = false;
	        form.buttonPrintBarcode.disabled = false;
	        form.checkBoxSendData.disabled = false;
		}
		else
		{
			form.buttonPrintBitmap.disabled = true;
	        form.buttonPrint.disabled = true;
	        form.buttonPrintBarcode.disabled = true;
	        form.checkBoxSendData.disabled = true;
		}
		
		//*************************************************************************************************************
		//Status
		if (form.buttonStatusStop.disabled == false) {
			form.icoHeadUp.src = icoInit;
	        form.icoPaperEnd.src = icoInit;
	        form.icoCutterError.src = icoInit;
	        form.icoHeadHot.src = icoInit;
	        form.icoPaperNearEnd.src = icoInit;
		}
		if((uni_OperationProcess == Macro_Process_Print) || ((uni_OperationProcess == Macro_Process_OpenPort) && (iPortType == KIOSK_LPT) || (iPortType == KIOSK_DRV)))
		{
			form.buttonStatusStart.disabled = true;
	        form.buttonStatusStop.disabled = true;	
		}
		else
		{
			if(uni_OperationProcess == Macro_Process_StatusMonitor)
			{
				form.buttonStatusStart.disabled = true;
	            form.buttonStatusStop.disabled = false;	
			}
			else
			{
				form.buttonStatusStart.disabled = false;
	            form.buttonStatusStop.disabled = true;	
			}			
		}
	}
}

/**********************************************************************************************************************
  Function: Port contorl.
  Input:	PortType: KIOSK_COM - KIOSK_DRV
  Output:	null	  
  Return:   void
**********************************************************************************************************************/
function selectPortControl()
{
	//*****************************************************************************************************************
	//Define veriables
	var	SelectCOMPort = false;
	var	SelectLPTPort = false;
	var	SelectNibbleParPort = false;
	var	SelectUSBAPIPort = false;
	var	SelectUSBClassPort = false;
	var	SelectDriverPort = false;

    iPortType = Number(iPortType);
	switch(iPortType)
	{
	//*****************************************************************************************************************
	//COM
	case KIOSK_COM: SelectCOMPort = true;
		break;
	//*****************************************************************************************************************
	//LPT
	case KIOSK_LPT: SelectLPTPort = true;
		break;
	//*****************************************************************************************************************
	//Nibblepar
	case KIOSK_NIBBLEPAR: SelectNibbleParPort = true;
		break;
	//*****************************************************************************************************************
	//USB API
	case KIOSK_USB: SelectUSBAPIPort = true;
		break;
	//*****************************************************************************************************************
	//USB Class
	case KIOSK_USBCLASSS: SelectUSBClassPort = true;
		break;
	//*****************************************************************************************************************
	//Driver
	case KIOSK_DRV: SelectDriverPort = true;
		break;
	}
	form.buttonPortSetting.disabled = !((iPortType != KIOSK_USB) && (uni_OperationProcess != Macro_Process_OpenPort) && (uni_OperationProcess != Macro_Process_StatusMonitor));

	//*****************************************************************************************************************
	//Gray control
	form.port_select[0].checked = SelectCOMPort;
	form.port_select[1].checked = SelectLPTPort;
	form.port_select[2].checked = SelectNibbleParPort;
	form.port_select[3].checked = SelectUSBAPIPort;
	form.port_select[4].checked = SelectUSBClassPort;
	form.port_select[5].checked = SelectDriverPort;
	
	form.port_select[0].disabled = SelectCOMPort;
	form.port_select[1].disabled = SelectLPTPort;
	form.port_select[2].disabled = SelectNibbleParPort;
	form.port_select[3].disabled = SelectUSBAPIPort;
	form.port_select[4].disabled = SelectUSBClassPort;
	form.port_select[5].disabled = SelectDriverPort;
}

/**********************************************************************************************************************
  Function: Set timeouts.
  Input:	readTimeouts: read timeouts.
		    writeTimeouts: write timeouts.
  Output:	null	  
  Return:   void
**********************************************************************************************************************/
function SetTimeouts(readTimeouts,writeTimeouts)
{
	var  returnValue = false;
	var  tempReturnValue = KIOSK_SUCCESS;

	//*****************************************************************************************************************
	//Close COM
	if(iPortType == KIOSK_COM)
	{
		tempReturnValue = KIOSKOCX.KIOSKSetComTimeOuts(m_hPort, 0, writeTimeouts, 0, readTimeouts);
	}
	//*****************************************************************************************************************
	//Close LPT
	else if(iPortType == KIOSK_LPT){}
	//*****************************************************************************************************************
	//Close Nibblepar
	else if(iPortType == KIOSK_NIBBLEPAR)
	{
		tempReturnValue = KIOSKOCX.KIOSKSetNibbleParTimeOuts(readTimeouts, writeTimeouts);
	}
	//*****************************************************************************************************************
	//Close USB API or USBClass
	else if(iPortType == KIOSK_USB || (iPortType == KIOSK_USBCLASSS))
	{	
		tempReturnValue = KIOSKOCX.KIOSKSetUsbTimeOuts(m_hPort, readTimeouts, writeTimeouts);
	}
	//*****************************************************************************************************************
	//Close Driver
	else if(iPortType == KIOSK_DRV){}
	if(tempReturnValue == KIOSK_SUCCESS)
	{
		returnValue = true;
	}
	return returnValue;
}


function getTextByteLength(pText) {

    var len = 0;

    var i = 0;

    for (i = 0; i < pText.length; i++) {

        if (pText.substr(i, 1).charCodeAt() > 1000)

        { len += 2; } else { len++; }

    }

    return len;

}