export class User {
    constructor(
        private id: string,
        private  name: string,
        private  surname: string,
        private  ucidn: string,
        private  address: string,
        private  city: string,
        private  country: string,
        private  email: string,
        private  phone: string,
        private  role: string,
        private  username: string,
        private  password: string
    ){}

    public getId(){
        return this.id;
    }
}