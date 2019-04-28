package id_123

import (
	"testing"
)

func Test_sortString(t *testing.T) {
	s := "国中"
	t.Log(sortString(s))
}

func Test_isAnagram(t *testing.T) {
	type args struct {
		s string
		t string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "test1",
			args: args{
				s: "abcd",
				t: "abcd",
			},
			want: true,
		},
		{
			name: "test2",
			args: args{
				s: "abdc",
				t: "abcd",
			},
			want: true,
		},
		{
			name: "test3",
			args: args{
				s: "abdc",
				t: "abcc",
			},
			want: false,
		},
		{
			name: "test4",
			args: args{
				s: "中国",
				t: "国中",
			},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isAnagram(tt.args.s, tt.args.t); got != tt.want {
				t.Errorf("isAnagram() = %v, want %v", got, tt.want)
			}
		})
	}
}
