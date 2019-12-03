import { User } from './user';

export class RequestForPatReg {
    constructor(
        private userData:User,
        private id:number,
        private isAccepted:boolean,
        private reasonOfRejection:string 
    ){}

    public getId(){
        return this.id;
    }
}