export class RequestForAbsence {
    constructor(
        public  id: number,
        public  applicant: string,
        public  isAccepted: boolean,
        public resaonOfRejection: string,
        public from: Date,
        public to: Date,
    ){}
}