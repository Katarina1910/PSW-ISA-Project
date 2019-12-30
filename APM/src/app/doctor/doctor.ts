import { User } from '../registration/user';

export class Doctor{
    constructor(
       public id :number,
       public name :string,
       public surname :string,
       public grade :number
    ) {}

}