export class User {
    constructor(
        private  name: string,
        private  surname: string,
        private  ucidn: string,
        private  address: string,
        private  city: string,
        private  country: string,
        private  email: string,
        private  phone: string,
        private  userName: string,
        private  password: string,
        private role:string
    ){}

    public getUserName(){
        return this.userName;
    }

    public getRole(){
        return this.role;
    }
}