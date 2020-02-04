import { User } from '../registration/user';
import { Timestamp } from 'rxjs/internal/operators/timestamp';

export class Doctor extends User{
    constructor(
        public clinic:number,
        public grade:number,
        public typeId: number,
        public scheduledFrom: Date,
        public scheduledTo: Date
     
    ) {
        super(null,null,null,null,null,null,null,null,null,null,null,null);
    }

}