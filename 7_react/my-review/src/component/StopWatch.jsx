import { useEffect, useState } from "react";

function StopWatch () {
    const [time, setTime] = useState(0);
    const [running, isRunning] = useState(false);
    

    useEffect(()=>{
        let timer
        
        if(running){
            timer = setInterval(()=>{
                setTime(time => time+1);
            }, 1000);
    
            return()=>{clearInterval(timer);}
        }
      },[running])

    return(
        <div className="App">
            <h1>Stopwatch</h1>

            <h2>{parseInt(time/60)}:{time%60<10 ? '0' + time%60 : time%60}</h2>
            <button onClick={()=>isRunning(true)}>Start</button>
            <button onClick={()=>isRunning(false)}>Stop</button>
            <button onClick={()=>{isRunning(false); setTime(0);}}>Reset</button>
        </div>
    )
}
export default StopWatch;