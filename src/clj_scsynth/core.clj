(ns clj-scsynth.core
  (:use [clj-native.core :only [defclib]]))

(defclib
  scsynth
  (:structs
   (worldoptions
    :password                  constchar* 

    :numbuffers                int 
    :maxlogins                 int 
    :maxnodes                  int 
    :maxgraphdefs              int 
    :maxwirebufs               int 
    :numaudiobuschannels       int 
    :numinputbuschannels       int 
    :numoutputbuschannels      int 
    :numcontrolbuschannels     int 
    :buflength                 int 
    :realtimememorysize        int 

    :numsharedcontrols         int
    :sharedcontrols            float*

    :realtime                  bool
    :memorylocking             bool

    :nonrealtimecmdfilename          constchar*  
    :nonrealtimeinputfilename        constchar* 
    :nonrealtimeoutputfilename       constchar* 
    :nonrealtimeoutputheaderformat   constchar* 
    :nonrealtimeoutputsampleformat   constchar* 
    
    :preferredsamplerate       int
    :numrgens                  int

    :preferredhardwarebufferframesize int

    :loadgraphdefs             int

    :indevicename              constchar*

    :verbosity                 int

    :rendezvous                bool

    :ugenspluginpath           constchar*

    :outdevicename             constchar*

    :restrictedpath            constchar*))
  (:functions
   (World_New [worldoptions*] void*)                                   
   ))

(loadlib-scsynth)

(def default-options 
     (let [opts (worldoptions-byref)]
       (set! (. opts password) nil)                  
       (set! (. opts numbuffers) 1024)
       (set! (. opts maxlogins) 64)
       (set! (. opts maxnodes) 1024)                  
       (set! (. opts maxgraphdefs) 1024)              
       (set! (. opts maxwirebufs) 64)               
       (set! (. opts numaudiobuschannels) 128)       
       (set! (. opts numinputbuschannels) 8)       
       (set! (. opts numoutputbuschannels) 8)      
       (set! (. opts numcontrolbuschannels) 4096)     
       (set! (. opts buflength) 64)                 
       (set! (. opts realtimememorysize) 8192)
  
       (set! (. opts numsharedcontrols) 0)
       (set! (. opts sharedcontrols) nil)
  
       (set! (. opts realtime) true)                  
       (set! (. opts memorylocking) false)
  
       (set! (. opts nonrealtimecmdfilename) nil)
       (set! (. opts nonrealtimeinputfilename) nil)  
       (set! (. opts nonrealtimeoutputfilename) nil) 
       (set! (. opts nonrealtimeoutputheaderformat) nil) 
       (set! (. opts nonrealtimeoutputsampleformat) nil)
  
       (set! (. opts preferredsamplerate) 0) ;; 44100 on windows
  
       (set! (. opts numrgens) 64)                 
       (set! (. opts preferredhardwarebufferframesize) 0) 
       (set! (. opts loadgraphdefs) 1)            
       (set! (. opts indevicename) nil)             
       (set! (. opts verbosity)                 0)                
       (set! (. opts rendezvous)                true)               
       (set! (. opts ugenspluginpath)           nil)          
       (set! (. opts outdevicename)             nil)            
       (set! (. opts restrictedpath)            nil)
       opts))

(def world (World_New default-options ))
