export class User {
    constructor(
        public id: string,
        public  name: string,
        public  surname: string,
        public  ucidn: string,
        public  address: string,
        public  city: string,
        public  country: string,
        public  email: string,
        public  phone: string,
        public  username: string,
        public  password: string,
        public  password2: string,
        public role:string,
    ){}

    public getId(){
        return this.id;
    }

    public getName(){
        return this.name;
    }

    public getSurnname(){
        return this.surname;
    }

    public getPhone(){
        return this.phone;
    }

    public getEmail(){
        return this.email;
    }

    public getUcidn(){
        return this.ucidn;
    }z
}