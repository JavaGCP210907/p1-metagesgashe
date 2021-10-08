
const url = "http://localhost:8090/"


let employeeLoginButton = document.getElementById("eLogin");
let managerLoginButton = document.getElementById("mLogin");
let addReimbursementBtn = document.getElementById("addReimbursementbtn");
let pastTicketBtn = document.getElementById("pastTicketsbtn");
let viewAllBtn = document.getElementById("viewAllBtn");
let reimbursementByStatus = document.getElementById("reimbursementByStatus");
let filterBtn = document.getElementById("filterBtn");
let filterBtn1 = document.getElementById("filterBtn1");
let submitRequest = document.getElementById("submitRequest");
let form = document.getElementById("form");
let errorMessage = document.getElementById("errorMessage");
let allReimbursements = document.getElementById("ersTable");
let allReimbursements2 = document.getElementById("ersTable2");
let userInput = document.getElementById("userInput");
let approvedBtn = document.getElementById("approvedBtn");
let denyBtn = document.getElementById("denyBtn");






if (employeeLoginButton != null){
    employeeLoginButton.addEventListener("click", eLogFunc);
}
if (managerLoginButton != null){
    managerLoginButton.addEventListener("click", mLogFunc);
}

if (addReimbursementBtn != null){
    addReimbursementBtn.addEventListener("click", addFunc);
}

if (pastTicketBtn != null){
    pastTicketBtn.addEventListener("click", viewOneFunc);
}

if (viewAllBtn != null){
    viewAllBtn.addEventListener("click", viewAllFunc)
}

if (filterBtn != null){
    filterBtn.addEventListener("click", filterFunc);
}

if (submitRequest != null){
    submitRequest.addEventListener("click", submitFunc);
}

if(approvedBtn != null){
    approvedBtn.addEventListener("click", approveFunc)
}

if(denyBtn != null){
    denyBtn.addEventListener("click", denyFunc)
}

async function eLogFunc () {
    
    let usern = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    

    let user = {
        username:usern,
        password:pass
    }

    console.log(user);

    let response = await fetch(url + "eLogin", {

        method: "POST", 
        body: JSON.stringify(user), 
        credentials: "include"
        
    });

   // console.log(response.status); 

    
    if(response.status === 200){
        
        document.getElementById("display").innerText="Welcome!";
        
        
    } else {
        document.getElementById("display").innerText="Sorry, unable to login!"
    }

        
   
}

async function mLogFunc () {
    
    let usern = document.getElementById("mUsername").value;
    let pass = document.getElementById("mPassword").value;
    

    let user = {
        username:usern,
        password:pass
    }

    console.log(user);

    let response = await fetch(url + "mLogin", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), 
        credentials: "include"
        
    });

    console.log(response.status); 

    
    if(response.status === 200){
        
        document.getElementById("display").innerText="Welcome!";
        
        
    } else {
        document.getElementById("display").innerText="Sorry, unable to login!"
    }

                   

                    

   
}

async function addFunc(){
    let personalTicket = document.getElementById("personalTicket");
    personalTicket.style.display = "none";
    userInput.style.display = "none";
    let allReimbursements = document.getElementById("ersTable");
    allReimbursements.style.display = "none";
    let valuesDisplay = document.getElementById("valuesDisplay");
    valuesDisplay.style.display = "none";
    document.getElementById("errorMessage").style.display = "none";

    let addForm = document.getElementById("addReimbursement");
    addForm.style.display = "block";

    
}

async function viewOneFunc(){
    let addForm = document.getElementById("addReimbursement");
    addForm.style.display = "none";
    
    let userInput = document.getElementById("userInput");
    userInput.style.display = "block";
    userInput = userInput.value
    let personalTicket = document.getElementById("personalTicket");
    personalTicket.style.display = "block";
    
    let response = await fetch(url + "ersById/" + userInput, {credentials: "include"})

    
    if (response.status === 200){
        
        let valuesDisplay = document.getElementById("valuesDisplay");
        valuesDisplay.style.display = "none";
           
        
        let allReimbursements = document.getElementById("ersTable");
        allReimbursements.style.display = "block";
        
        personalTicket.setAttribute("class", "text-dark");

        let data = await response.json()
        console.log(data);
       // for (let ers of data){
            let reimbursementById = document.getElementById("reimbursementById");
    
            let tr = document.createElement("tr");
    
            let td1 = document.createElement("td");
            td1.innerText = data.reimb_id;
            tr.appendChild(td1); 
    
            let td2 = document.createElement("td");
            td2.innerText = data.reimb_amount;
            tr.appendChild(td2);
    
            let td3 = document.createElement("td")
            td3.innerText = data.reimb_submitted;
            tr.appendChild(td3);
    
            let td4 = document.createElement("td");
            td4.innerText = data.reimb_description;
            tr.appendChild(td4); 
    
            let td5 = document.createElement("td");
            td5.innerText = data.reimb_receipt
            tr.appendChild(td5);
    
            let td6 = document.createElement("td");
            td6.innerText = data.reimb_author.user_first_name;
            tr.appendChild(td6);
    
            let td7 = document.createElement("td");
            td7.innerText = data.reimb_resolver.user_first_name
            tr.appendChild(td7);
    
            let td8 = document.createElement("td");
            td8.innerText = data.reimb_status.status
            tr.appendChild(td8);
    
            let td9 = document.createElement("td");
            td9.innerText = data.reimb_type.type
            tr.appendChild(td9);
    
        
        
            reimbursementById.appendChild(tr);
            personalTicket.style.display = "none"
           
       // }
    }  else {
        personalTicket.setAttribute("class", "text-danger");
        personalTicket.innerText = "Please login and enter the reimbursement Id!"
        allReimbursements.style.display = "none";
    }
    
    
    
}

async function viewAllFunc(){

  
let response = await fetch(url + "allErs", {credentials: "include"});
let allReimbursements = document.getElementById("ersTable");
allReimbursements.style.display = "block";

if (response.status === 200){
    let reimbursementByStatus = document.getElementById("reimbursementByStatus");
    reimbursementByStatus.style.display = "none";
    let allReimbursements2 = document.getElementById("ersTable2");
    allReimbursements2.style.display = "none";  
    

    let data = await response.json();
    console.log(data);
    for (let ers of data){
        
        

        let tr = document.createElement("tr");

        let td1 = document.createElement("td");
        td1.innerText = ers.reimb_id;
        tr.appendChild(td1); 

        let td2 = document.createElement("td");
        td2.innerText = ers.reimb_amount;
        tr.appendChild(td2);

        let td3 = document.createElement("td")
        td3.innerText = ers.reimb_submitted;
        tr.appendChild(td3);

        let td4 = document.createElement("td");
        td4.innerText = ers.reimb_description;
        tr.appendChild(td4); 

        let td5 = document.createElement("td");
        td5.innerText = ers.reimb_receipt
        tr.appendChild(td5);

        let td6 = document.createElement("td");
        td6.innerText = ers.reimb_author.user_first_name;
        tr.appendChild(td6);

        let td7 = document.createElement("td");
        td7.innerText = ers.reimb_resolver.user_first_name
        tr.appendChild(td7);

        let td8 = document.createElement("td");
        td8.innerText = ers.reimb_status.status
        tr.appendChild(td8);

        let td9 = document.createElement("td");
        td9.innerText = ers.reimb_type.type
        tr.appendChild(td9);

    
    
        allReimbursements.appendChild(tr);
    }
    
    
}else {
    allReimbursements.innerText = "Please login first"
}


}

async function filterFunc(){

    let response = await fetch(url + "allErs", {credentials: "include"});
    let allReimbursements2 = document.getElementById("ersTable2");
    allReimbursements2.style.display = "block";

        if (response.status === 200){
            
            let allReimbursements = document.getElementById("ersTable");
            allReimbursements.style.display = "none";
            let reimbursementByStatus = document.getElementById("reimbursementByStatus");
           
            
            let data = await response.json();
            console.log(data);

            for (let ers of data){
                let tr = document.createElement("tr");
            
                let td1 = document.createElement("td");
            
                let td2 = document.createElement("td");
              
                let td3 = document.createElement("td")
                
                let td4 = document.createElement("td");
                
                let td5 = document.createElement("td");
                
                let td6 = document.createElement("td");
                
                let td7 = document.createElement("td");
               
                let td8 = document.createElement("td");
               
                let td9 = document.createElement("td");

                let td10 = document.createElement("input");

                
                
        
                if (filterBtn1.value === "pending" && ers.reimb_status.status === "pending"){
                
                    td1.innerText = ers.reimb_id;
                    tr.appendChild(td1); 

                    td2.innerText = ers.reimb_amount;
                    tr.appendChild(td2);

                    td3.innerText = ers.reimb_submitted;
                    tr.appendChild(td3);

                    td4.innerText = ers.reimb_description;
                    tr.appendChild(td4); 

                    td5.innerText = ers.reimb_receipt
                    tr.appendChild(td5);

                    td6.innerText = ers.reimb_author.user_first_name;
                    tr.appendChild(td6);

                    td7.innerText = ers.reimb_resolver.user_first_name
                    tr.appendChild(td7);

                    td8.innerText = ers.reimb_status.status
                    tr.appendChild(td8);

                    td9.innerText = ers.reimb_type.type
                    tr.appendChild(td9);

                    td10.setAttribute("type", "checkbox");
                    tr.appendChild(td10)


                    allReimbursements2.appendChild(tr);

                } else if (filterBtn1.value === "aproved" && ers.reimb_status.status === "approved"){
                    
                    td1.innerText = ers.reimb_id;
                    tr.appendChild(td1); 

                    td2.innerText = ers.reimb_amount;
                    tr.appendChild(td2);

                    td3.innerText = ers.reimb_submitted;
                    tr.appendChild(td3);

                    td4.innerText = ers.reimb_description;
                    tr.appendChild(td4); 

                    td5.innerText = ers.reimb_receipt
                    tr.appendChild(td5);

                    td6.innerText = ers.reimb_author.user_first_name;
                    tr.appendChild(td6);

                    td7.innerText = ers.reimb_resolver.user_first_name
                    tr.appendChild(td7);

                    td8.innerText = ers.reimb_status.status
                    tr.appendChild(td8);

                    td9.innerText = ers.reimb_type.type
                    tr.appendChild(td9);

                   
                    


                    allReimbursements2.appendChild(tr);

                } else if (filterBtn1.value === "denied" && ers.reimb_status.status === "denied"){
                    
                    td1.innerText = ers.reimb_id;
                    tr.appendChild(td1); 

                    td2.innerText = ers.reimb_amount;
                    tr.appendChild(td2);

                    td3.innerText = ers.reimb_submitted;
                    tr.appendChild(td3);

                    td4.innerText = ers.reimb_description;
                    tr.appendChild(td4); 

                    td5.innerText = ers.reimb_receipt
                    tr.appendChild(td5);

                    td6.innerText = ers.reimb_author.user_first_name;
                    tr.appendChild(td6);

                    td7.innerText = ers.reimb_resolver.user_first_name
                    tr.appendChild(td7);

                    td8.innerText = ers.reimb_status.status
                    tr.appendChild(td8);

                    td9.innerText = ers.reimb_type.type
                    tr.appendChild(td9);

                    td10.setAttribute("type", "checkbox");
                    tr.appendChild(td10)

                    
                    allReimbursements2.appendChild(tr);

                } else {
                   // allReimbursements2.innerText = "Sorry something went wrong"
                    // p.style.display = "none";
                }
            }
        } else {
            console.log("Sorry something went wrong");
            allReimbursements2.innerText = "Please login first"
        }
        
    } 
    
    


async function submitFunc(){
    

    let valuesDisplay = document.getElementById("valuesDisplay");
    valuesDisplay.style.display = "block";

    let reimb_amount = document.getElementById("reimb_amount");
    let reimb_submitted = document.getElementById("reimb_submitted");
    let reimb_resolved = document.getElementById("reimb_resolved");
    let reimb_description = document.getElementById("reimb_description");
   // let reimb_author = document.getElementById("reimb_author");
    let reimb_resolver = document.getElementById("reimb_resolver");
    let reimb_status = document.getElementById("reimb_status");
    let reimb_type = document.getElementById("reimb_type");

    let ers_password2 = document.getElementById("password2");
    let ers_user_name2 = document.getElementById("username2");
    let user_email = document.getElementById("user_email");
    let user_first_name = document.getElementById("user_first_name");
    let user_last_name = document.getElementById("user_last_name");
    let user_role_id = document.getElementById("user_role_id");

    if (reimb_amount.value === "" ||reimb_description.value === "" || reimb_status.value === "" || reimb_type.value === "" ||ers_password2.value === "" ||
    ers_user_name2.value === "" || user_email.value === "" || user_first_name.value === "" || user_last_name.value === ""){
    
        errorMessage.style.display = "block";
        errorMessage.innerText = "Please fill all the required fields!"
        valuesDisplay.style.display = "none";

    } else {
        let addForm = document.getElementById("addReimbursement");
        addForm.style.display = "none";
        let personalTicket = document.getElementById("personalTicket");
        personalTicket.style.display = "none";
        
        let p1 = document.createElement("p");
        p1.innerText = "Reimbursement request submited successfuly!";
        p1.setAttribute("class", "text-success")
        
    

        const data = { 
            reimb_amount:  reimb_amount.value,
            reimb_submitted: new Date().toDateString(),
            reimb_resolved: null,
            reimb_description: reimb_description.value,
            reimb_receipt: null,
            reimb_author: {ers_password: ers_password2.value,
                ers_user_name: ers_user_name2.value,
                user_email: user_email.value,
                user_first_name: user_first_name.value,
                user_last_name: user_last_name.value,
                user_role_id: {ers_user_role: "employee"}
            },
            reimb_resolver: {ers_password: "456",
                ers_user_name: "manager",
                user_email: "emageorge@example.com",
                user_first_name: "Ema",
                user_last_name: "George",
                user_role_id: {ers_user_role: "f_manager"}
            },
            reimb_status: {status: reimb_status.value},
            reimb_type: {type: reimb_type.value}
        };
        console.log(data);
        console.log(data.reimb_status.status.reimb_status_id)

        let response = await fetch(url+"submit", {

            method: "POST", //send a POST request
            body: JSON.stringify(data), //turn our Javascript into JSON
            credentials: "include"
            
        })

    // console.log(response); 

        
        if(response.status === 201){
            
            console.log("success!")
        } else {
        
            console.log("failed")
        }

        
        valuesDisplay.appendChild(p1);
        

        form.reset()
    }
}


async function approveFunc (){
    //let response = await fetch(url + "allErs", {credentials: "include"});
    let checkBox = document.querySelectorAll('[type="checkbox"]')[0];
    
    if (checkBox.checked){
        
       
        let parent = checkBox.parentElement;
        let num = parseInt(parent.innerHTML[4])

        let response = await fetch(url + "ersById/" + num, {credentials: "include"})

        if (response.status === 200){
        
            let data = await response.json()

           // console.log(data);

            const data1 = { 
                "reimb_id": num,
                "reimb_amount": data.reimb_amount,
                "reimb_submitted": data.reimb_submitted,
                "reimb_description": data.reimb_description,
                "reimb_receipt": data.reimb_receipt,
                "reimb_author": data.reimb_author,
                "reimb_resolver": data.reimb_resolver,
                "reimb_status": {reimb_status_id: 2, status: "approved" },
                "reimb_type": data.reimb_type
            }
            console.log(data1);
            console.log(data1.reimb_status.status)
    
            let response2 = await fetch(url+"update", {
    
                method: "POST", 
                body: JSON.stringify(data1), 
                credentials: "include"
                
            })

            
        console.log(response2.body); 

        
        if(response2.status === 201){
            
            console.log("success!")
        } else {
        
            console.log("failed")
        }
    
          
        }  else {
            personalTicket.setAttribute("class", "text-danger");
            personalTicket.innerText = "Please login and enter the reimbursement Id!"
            allReimbursements.style.display = "none";
        }


     }
        

    }
    
    async function denyFunc(){
        let checkBox2 = document.querySelectorAll('[type="checkbox"]')[0];
    
        if (checkBox2.checked){
            
           
           console.log(checkBox2[0]);
    
            
            let parent = checkBox2.parentElement;
            let num = parseInt(parent.innerHTML[4])
    
            let response = await fetch(url + "ersById/" + num, {credentials: "include"})
    
            if (response.status === 200){
            
                let data = await response.json()
    
               // console.log(data);
    
                const data1 = { 
                    "reimb_id": num,
                    "reimb_amount": data.reimb_amount,
                    "reimb_submitted": data.reimb_submitted,
                    "reimb_description": data.reimb_description,
                    "reimb_receipt": data.reimb_receipt,
                    "reimb_author": data.reimb_author,
                    "reimb_resolver": data.reimb_resolver,
                    "reimb_status": {reimb_status_id: 3, status: "denied" },
                    "reimb_type": data.reimb_type
                }
                console.log(data1);
                console.log(data1.reimb_status.status)
        
                let response2 = await fetch(url+"update", {
        
                    method: "POST", 
                    body: JSON.stringify(data1), 
                    credentials: "include"
                    
                })
    
                
            console.log(response2.body); 
    
            
            if(response2.status === 201){
                
                console.log("success!")
            } else {
            
                console.log("failed")
            }
        
              
            }  else {
                personalTicket.setAttribute("class", "text-danger");
                personalTicket.innerText = "Please login and enter the reimbursement Id!"
                allReimbursements.style.display = "none";
            }
    
    
         }
    }