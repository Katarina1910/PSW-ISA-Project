import { User } from '../registration/user';

export class Doctor extends User{
    constructor(
        public clinic:number,
        public grade:number,
        public typeId: number
     
    ) {
        super(null,null,null,null,null,null,null,null,null,null,null,null);
    }

}