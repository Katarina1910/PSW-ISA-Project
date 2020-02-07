import { OnInit, Component } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

@Component({
    selector: 'consu-term-report',
    templateUrl: './consultTermReport.component.html'
  })

  export class ConsultTermReportComponent implements OnInit {

    dropdownList = [];
    selectedItems = [];
    dropdownSettings = {};

    ngOnInit(){
        
        this.dropdownSettings = {
            singleSelection: false,
            idField: 'item_id',
            textField: 'item_text',
            selectAllText: 'Select All',
            unSelectAllText: 'UnSelect All',
            itemsShowLimit: 3,
            allowSearchFilter: true
          };
    }
    
    onItemSelect(item: any) {
        console.log(item);
      }
      onSelectAll(items: any) {
        console.log(items);
      }
}
