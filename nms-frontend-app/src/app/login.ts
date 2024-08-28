
// Map to entity class
// login table
// pid int primary key
//email_id varchar(255)
//password varchar(255)
//type_of_user varchar(255)

export class Login {
    constructor(public pid:number, public emailId:string, public password:string,public typeOfUser:string){
            
        }
}
