Graphics 800,600,0,6
SetBuffer BackBuffer()
AppTitle "MSA 2013 - Physicsimulationen in der Informatik - Copuright (c) 2013 by Jochen Jacobs & Leonard Robert Koenig"

Include "Help.bb"
Include "Ph_Main.bb"

Local Testobject1.Ph_Object = New Ph_Object
Testobject1\Pos[0] = 1
Testobject1\Pos[1] = 1.2
Testobject1\Mass = 5

Local CBox.Shape = Sh_CreateSquare(-0.4,-1,0.4,1)
Testobject1\CollisionBox = CBox
Testobject1\Image = Ph_CreateImagefromCollisonBox(CBox)
Testobject1\RotMass = Ph_CalculateMomentOfInertia(CBox,Testobject1\Mass)

;Local a#[1]
;a[0] = 0.01
;a[1] = -1

;Local b#[1]
;b[0] = 20
;b[1] = 0

;Ph_ApplyForce(Testobject1, a, b)
Local force1#[1]
Local pos1#[1]
Local force2#[1]
Local pos2#[1]

Local LastTime# = MilliSecs()

Repeat
	
	Cls
	
	
	force1[0] = 0
	force1[1] = 0.2
	
	pos1[0] = 0.3
	pos1[1] = 1
	
	
	Ph_ApplyForce(Testobject1, force1, pos1)
	
	;Print Testobject1\RotVel
	
;	Print Testobject1\Vel[0]
	
	
	force2[0] = 0
	force2[1] = 0.1
	pos2[0] = -0.3
	pos2[1] = 1
	
	Ph_ApplyForce(Testobject1, force2, pos2)
	
;	Print Testobject1\Vel[0]
	
 ;   WaitKey()
    ;Print Testobject1\RotVel
	
	
	
	
	Ph_DoTick(Testobject1, (MilliSecs()-LastTime)/1000)
	;Print (MilliSecs()-LastTime)/1000
	;WaitKey()
	LastTime=MilliSecs()
	Ph_Render(Testobject1)
	
	Color 255,255,0
	Line pos1[0]*100+Testobject1\Pos[0]*100,pos1[1]*100+Testobject1\Pos[1]*100,pos1[0]*100+Testobject1\Pos[0]*100+force1[0]*200,pos1[1]*100+Testobject1\Pos[1]*100+force1[1]*200
	Line pos2[0]*100+Testobject1\Pos[0]*100,pos2[1]*100+Testobject1\Pos[1]*100,pos2[0]*100+Testobject1\Pos[0]*100+force2[0]*200,pos2[1]*100+Testobject1\Pos[1]*100+force2[1]*200
	
	
	Flip
Until KeyHit(1)
End


;Todo next:
; - Traegheitsmoment ueberpruefen - OK -
; - Anzeige - OK - 
; - GUI - Just Easy - 
; - Kollision - Do next -
;~IDEal Editor Parameters:
;~C#Blitz3D