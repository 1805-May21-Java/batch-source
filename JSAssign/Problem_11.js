function printShape(arg, arg2, arg3){
    let x = arg3.charAt(0);
    let y = arg;
    let z = arg2;
    let t="";
    if(y.toUpperCase()==="SQUARE"){
        y="S";
    }else if(y.toUpperCase()==="TRIANGLE"){
        y="T";
    }else if(y.toUpperCase()==="DIAMOND"){
        y="D";
    }else{
        console.log("Invalid Shape Param");
        return false;
    }
    if(y==="S"){
        while(t.length<=z){
            t+=x;
        }
        for(let i=z;i>0;i--) {
            console.log(t);
        }
    }else if(y==="T"){
        for(let i=0;i<z;i++){
            t+=x;
            console.log(t);
        }
    }else if(y==="D") {
        for (let i = 0; i < z; i++) {
            t+=x;
            console.log(t);
        }
        t="";
        for(let i = z; i>0; i--){
            while(t.length<i-1){
                t+=x;
            }
            console.log(t);
            t="";
        }
    }
}

printShape("Diamond", 4, "%");
printShape("Triangle", 6, "$");
printShape("Square", 5, "#");
